package io.github.aj8gh.aoc.y22.d6;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day6Test extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(String input, int expected) {
    var day6 = new Day6();
    var actual = day6.part1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(String input, int expected) {
    var day6 = new Day6();
    var actual = day6.part2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_6).asStringList().get(0), 7),
        Arguments.of(reader().getExample(DAY_6).asStringList().get(1), 5),
        Arguments.of(reader().getExample(DAY_6).asStringList().get(2), 6),
        Arguments.of(reader().getExample(DAY_6).asStringList().get(3), 10),
        Arguments.of(reader().getExample(DAY_6).asStringList().get(4), 11),
        Arguments.of(reader().getInput(DAY_6).asString(), 1760)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_6).asStringList().get(0), 19),
        Arguments.of(reader().getExample(DAY_6).asStringList().get(1), 23),
        Arguments.of(reader().getExample(DAY_6).asStringList().get(2), 23),
        Arguments.of(reader().getExample(DAY_6).asStringList().get(3), 29),
        Arguments.of(reader().getExample(DAY_6).asStringList().get(4), 26),
        Arguments.of(reader().getInput(DAY_6).asString(), 2974)
    );
  }
}
