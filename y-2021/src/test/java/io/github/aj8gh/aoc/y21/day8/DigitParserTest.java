package io.github.aj8gh.aoc.y21.day8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DigitParserTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day8part1(List<String> input, int expected) {
    var digitParser = new DigitParser();
    var actual = digitParser.getUniqueDigitCount(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void day8part2(List<String> input, int expected) {
    var digitParser = new DigitParser();
    var actual = digitParser.getTotalOutput(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_8).asStringList(), 26),
        Arguments.of(reader().getInput(DAY_8).asStringList(), 321)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_8).asStringList(), 61229),
        Arguments.of(reader().getInput(DAY_8).asStringList(), 1028926)
    );
  }
}
