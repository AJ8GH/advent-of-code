package io.github.aj8gh.aoc.y22.d11;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day11Test extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(List<String> input, long expected) {
    var day11 = new Day11();
    var actual = day11.part1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(List<String> input, long expected) {
   var day11 = new Day11();
    var actual = day11.part2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_11).asStringList(), 10_605L),
        Arguments.of(reader().getInput(DAY_11).asStringList(), 117_624L)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_11).asStringList(), 2_713_310_158L),
        Arguments.of(reader().getInput(DAY_11).asStringList(), 16_792_940_265L)
    );
  }
}
