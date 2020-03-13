package task8.com.epam.prykhodko.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class FindSequenceTest {

  @Mock
  Object monitor = new Object();
  FindSequence findSequence;

  @BeforeEach
  void init() {
    findSequence = new FindSequence(monitor);
  }

  @Test
  void getFinishShouldReturnFalse() {
    assertFalse(findSequence.getFinish());
  }

  @Test
  void setFinishShouldReturnTrue() {
    findSequence.setFinish(true);
    assertTrue(findSequence.getFinish());
  }

  @Test
  void setContent() {
    findSequence.setContent("a");
  }

  @Test
  void setQuite() {
    findSequence.setExit("stop");
  }

  @Test
  void testToString() {
    assertEquals("length=0, startPosition=0, endPosition=0", findSequence.toString());
  }
}