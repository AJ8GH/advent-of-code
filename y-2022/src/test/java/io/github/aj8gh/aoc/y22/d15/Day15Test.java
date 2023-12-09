package io.github.aj8gh.aoc.y22.d15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Disabled
class Day15Test extends InputProvider {

  private Day15 subject;

  @BeforeEach
  void setUp() {
    subject = new Day15();
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(List<String> input, int rowToCheck, int expected) {
    var actual = subject.part1(input, rowToCheck);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(List<String> input, int upperBound, int expected) {
    var actual = subject.part2(input, upperBound);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return getInput(
        26, 10,
        6_078_701, 2_000_000
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return getInput(
        56_000_011, 20,
        0, 4_000_000
    );
  }

  private static Stream<Arguments> getInput(int example, int i, int result, int j) {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_15).asStringList(), i, example),
        Arguments.of(reader().getInput(DAY_15).asStringList(), j, result)
    );
  }
}
