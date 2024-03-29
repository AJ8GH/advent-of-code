package io.github.aj8gh.aoc.y22.d9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day9Test extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(List<String> input, int expected) {
    var day9 = new Day9();
    var actual = day9.part1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(List<String> input, int expected) {
    var day9 = new Day9();
    var actual = day9.part2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_9).asStringList(), 13),
        Arguments.of(reader().getInput(DAY_9).asStringList(), 6498)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_9).asStringList(), 1),
        Arguments.of(reader().getExample2(DAY_9).asStringList(), 36),
        Arguments.of(reader().getExample3(DAY_9).asStringList(), 10),
        Arguments.of(reader().getInput(DAY_9).asStringList(), 2531)
    );
  }
}
