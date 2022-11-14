package io.github.aj8gh.aoc.y15.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AreaCalculatorTest extends InputProvider {

  private static final int DAY_2 = 2;

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart1")
  void calculatePaper(List<String> input, int expected) {
    var calculator = new AreaCalculator();
    assertEquals(expected, calculator.calculatePaper(input));
  }

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart2")
  void calculateRibbon(List<String> input, int expected) {
    var calculator = new AreaCalculator();
    assertEquals(expected, calculator.calculateRibbon(input));
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(List.of("2x3x4"), 58),
        Arguments.of(List.of("1x1x10"), 43),
        Arguments.of(getInput(), 1586300)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(List.of("2x3x4"), 34),
        Arguments.of(List.of("1x1x10"), 14),
        Arguments.of(getInput(), 3737498)
    );
  }

  private static List<String> getInput() {
    return reader().getInput(DAY_2).asStringList();
  }
}
