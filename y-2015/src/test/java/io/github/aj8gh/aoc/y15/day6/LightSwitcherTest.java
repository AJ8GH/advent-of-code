package io.github.aj8gh.aoc.y15.day6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.ReaderProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LightSwitcherTest extends ReaderProvider {

  private static final int DAY_6 = 6;

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart1")
  void processPart1(List<String> input, int expected) {
    var lightSwitcher = new LightSwitcher();
    assertEquals(expected, lightSwitcher.processPart1(input));
  }

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart2")
  void processPart2(List<String> input, int expected) {
    var lightSwitcher = new LightSwitcher();
    assertEquals(expected, lightSwitcher.processPart2(input));
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_6).asStringList(), 998_996),
        Arguments.of(reader().getInput(DAY_6).asStringList(), 543_903)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_6).asStringList(), 1_001_996),
        Arguments.of(reader().getInput(DAY_6).asStringList(), 14_687_245)
    );
  }
}
