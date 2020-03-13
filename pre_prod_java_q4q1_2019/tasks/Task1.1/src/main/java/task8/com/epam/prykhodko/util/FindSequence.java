package task8.com.epam.prykhodko.util;

import static com.epam.prykhodko.constant.Constants.STOP_STRING;
import static com.epam.prykhodko.constant.Constants.THREAD_INTERRUPTED;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class FindSequence implements Runnable {

  private static final Logger LOGGER = Logger.getLogger(FindSequence.class);
  private final Object monitor;
  private String content;
  private StringBuilder mainSB = new StringBuilder();
  private AtomicInteger length = new AtomicInteger(0);
  private int finalLength;
  private int startPosition;
  private int endPosition;
  private Boolean finishFlag = false;
  private String exit = StringUtils.EMPTY;

  public FindSequence(Object monitor) {
    this.monitor = monitor;
  }

  @Override
  public void run() {
    while (true) {
      synchronized (monitor) {
        if (STOP_STRING.equals(exit)) {
          break;
        }
        findSequence();
        finishFlag = true;
        try {
          monitor.notifyAll();
          monitor.wait();
        } catch (InterruptedException e) {
          LOGGER.error(THREAD_INTERRUPTED);
        }
      }
    }
  }

  public boolean getFinish() {
    return finishFlag;
  }

  public void setFinish(boolean endFlag) {
    this.finishFlag = endFlag;
  }

  private void findSequence() {
    char[] buffer = content.toCharArray();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < buffer.length; i++) {
      sb.append(buffer[i]);
      for (int j = i; j < buffer.length; j++) {
        if (j != i) {
          sb.append(buffer[j]);
        }
        if (!hasDuplicate(sb.toString().toCharArray(), j)) {
          sb.deleteCharAt(sb.length() - 1);
          break;
        }
      }

      if (sb.length() > mainSB.length()) {
        try {
          synchronized (monitor) {
            mainSB = sb;
            length.set(sb.length());
            monitor.notifyAll();
            monitor.wait();
          }
        } catch (InterruptedException e) {
          LOGGER.error(THREAD_INTERRUPTED);
        }
      }
      sb = new StringBuilder();
    }
    finalLength = mainSB.toString().length();
    startPosition = content.indexOf(mainSB.toString());
    endPosition = content.indexOf(mainSB.toString(), startPosition + 1);
    length.set(0);
    mainSB = new StringBuilder();
  }

  private boolean hasDuplicate(char[] buffer, int i) {
    String sequence = String.valueOf(buffer);
    String subSequence = content.subSequence(i + 1, content.length()).toString();
    return subSequence.contains(sequence);
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getLength() {
    return length.get();
  }

  public void setExit(String exit) {
    this.exit = exit;
  }

  public int getFinalLength() {
    return finalLength;
  }

  @Override
  public String toString() {
    return "length=" + finalLength
        + ", startPosition=" + startPosition
        + ", endPosition=" + endPosition;
  }
}