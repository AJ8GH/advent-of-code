package io.github.aj8gh.aoc.y22.d7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day7Test extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(List<String> input, long expected) {
    var day7 = new Day7();
    var actual = day7.part1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(List<String> input, long expected) {
    var day7 = new Day7();
    var actual = day7.part2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_7).asStringList(), 95_437L),
        Arguments.of(reader().getInput(DAY_7).asStringList(), 1_390_824L)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_7).asStringList(), 24_933_642L),
        Arguments.of(reader().getInput(DAY_7).asStringList(), 7_490_863L)
    );
  }
}
