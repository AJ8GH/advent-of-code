package io.github.aj8gh.aoc.y15.day3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DeliveryTrackerTest extends InputProvider {

  private static final int DAY_3 = 3;

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart1")
  void track(String input, int expected) {
    var tracker = new DeliveryTracker();
    assertEquals(expected, tracker.track(input));
  }

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart2")
  void trackRobo(String input, int expected) {
    var tracker = new DeliveryTracker();
    assertEquals(expected, tracker.trackRobo(input));
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(">", 2),
        Arguments.of("^>v<", 4),
        Arguments.of("^v^v^v^v^v", 2),
        Arguments.of(getInput(), 2081)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of("^>", 3),
        Arguments.of("^>v<", 3),
        Arguments.of("^v^v^v^v^v", 11),
        Arguments.of(getInput(), 2341)
    );
  }

  private static String getInput() {
    return reader().getInput(DAY_3).asString();
  }
}
