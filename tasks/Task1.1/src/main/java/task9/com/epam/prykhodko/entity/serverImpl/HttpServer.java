package task9.com.epam.prykhodko.entity.serverImpl;

import static com.epam.prykhodko.constant.Constants.HEADER_ERROR;
import static com.epam.prykhodko.constant.Constants.INCORRECT_INPUT;
import static com.epam.prykhodko.constant.Constants.PAGE_NOT_FOUND;

import com.epam.prykhodko.command.Command;
import com.epam.prykhodko.service.ProductService;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;
import task9.com.epam.prykhodko.entity.WriteType;
import task9.com.epam.prykhodko.util.ServerWriterUtil;

public class HttpServer implements Runnable {

  private static final Logger LOGGER = Logger.getLogger(HttpServer.class);
  private final Map<String, Command> commands = new HashMap<>();
  private final WriteType writeType;
  private StringBuilder request = new StringBuilder();
  private Socket socket;
  private ProductService productService;

  public HttpServer(Socket socket, ProductService productService, WriteType writeType) {
    this.socket = socket;
    this.productService = productService;
    this.writeType = writeType;
  }

  public void run() {
    try {
      ServerWriterUtil serverWriterUtil = new ServerWriterUtil(writeType);
      serverWriterUtil.write(commands, new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), request, productService);
      readInputHeaders();
      writeResponse();
    } catch (IOException t) {
      LOGGER.error(INCORRECT_INPUT);
    } finally {
      try {
        socket.close();
      } catch (IOException t) {
        LOGGER.error(INCORRECT_INPUT);
      }
    }
  }

  private void writeResponse() throws IOException {
    for (Entry<String, Command> entry : commands.entrySet()) {
      if (request.toString().contains(entry.getKey())) {
        entry.getValue().execute();
        return;
      }
    }
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    bufferedWriter.write(HEADER_ERROR + PAGE_NOT_FOUND);
    bufferedWriter.newLine();
    bufferedWriter.flush();
    bufferedWriter.close();
  }

  private void readInputHeaders() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    String buffer = br.readLine();
    Pattern pattern = Pattern.compile("=[\\w+1-9]");
    Matcher matcherWithEqual = pattern.matcher(buffer);
    if (matcherWithEqual.find()) {
      request.append("item").append(matcherWithEqual.group());
      return;
    }
    Pattern patternCount = Pattern.compile("(?<=/)\\w+(?=\\s|\\?)");
    Matcher matcher = patternCount.matcher(buffer);
    if (matcher.find()) {
      request.append(matcher.group());
    }
  }
}
