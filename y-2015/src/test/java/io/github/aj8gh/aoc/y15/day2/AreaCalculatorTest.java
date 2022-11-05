package io.github.aj8gh.aoc.y15.day2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.Reader;
import io.github.aj8gh.aoc.util.ReaderProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class AreaCalculatorTest extends ReaderProvider {

  private static final int DAY_2 = 2;

  @ParameterizedTest
  @MethodSource(value = "inputProvider")
  void getNegativePosition(List<String> input, long expected) {
    var calculator = new AreaCalculator();
    assertEquals(expected, calculator.calculate(input));
  }

  private static Stream<Arguments> inputProvider() {
    return Stream.of(
        Arguments.of(List.of("2x3x4"), 58),
        Arguments.of(List.of("1x1x10"), 43),
        Arguments.of(reader().getInput(DAY_2).asStringList(), 1586300)
    );
  }
}
