package io.github.aj8gh.aoc.y22.d14;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day14Test extends InputProvider {

  private Day14 subject;

  @BeforeEach
  void setUp() {
    subject = new Day14();
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
    return getInput(24, 696);
  }

  private static Stream<Arguments> inputProviderPart2() {
    return getInput(93, 23_610);
  }

  private static Stream<Arguments> getInput(int example, int result) {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_14).asNestedStringList(" -> "), example),
        Arguments.of(reader().getInput(DAY_14).asNestedStringList(" -> "), result)
    );
  }
}
