package io.github.aj8gh.aoc.y23.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day2Test extends InputProvider {

  private Day2 classUnderTest;

  @BeforeEach
  void setUp() {
    classUnderTest = new Day2();
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(List<String> input, int expected) {
    var actual = classUnderTest.part1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(List<String> input, int expected) {
    var actual = classUnderTest.part2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return getInput(8, 2593);
  }

  private static Stream<Arguments> inputProviderPart2() {
    return getInput(2286, 54699);
  }

  private static Stream<Arguments> getInput(int example, int result) {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_2).asStringList(), example),
        Arguments.of(reader().getInput(DAY_2).asStringList(), result)
    );
  }
}
