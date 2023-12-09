package io.github.aj8gh.aoc.y23.d3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day3Test extends InputProvider {

  private Day3 subject;

  @BeforeEach
  void setUp() {
    subject = new Day3();
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(List<List<String>> input, int expected) {
    var actual = subject.part1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(List<List<String>> input, int expected) {
    var actual = subject.part2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return getInput(4361, 553825);
  }

  private static Stream<Arguments> inputProviderPart2() {
    return getInput(467835, 93994191);
  }

  private static Stream<Arguments> getInput(int example, int result) {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_3).asNestedStringList(), example),
        Arguments.of(reader().getInput(DAY_3).asNestedStringList(), result)
    );
  }
}
