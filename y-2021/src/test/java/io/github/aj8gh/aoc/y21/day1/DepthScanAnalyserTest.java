package io.github.aj8gh.aoc.y21.day1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DepthScanAnalyserTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart1")
  void day1Part1(List<Integer> input, int expected) {
    var analyser = new DepthScanAnalyser();
    var actual = analyser.getNumberOfDepthIncreases(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart2")
  void day1Part2(List<Integer> input, int expected) {
    var analyser = new DepthScanAnalyser();
    var actual = analyser.getThreeDepthWindowIncreases(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(getExample(), 7),
        Arguments.of(getInput(), 1557)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(getExample(), 5),
        Arguments.of(getInput(), 1608)
    );
  }

  private static List<Integer> getInput() {
    return reader().getInput(DAY_1).asIntList();
  }

  private static List<Integer> getExample() {
    return reader().getExample(DAY_1).asIntList();
  }
}
