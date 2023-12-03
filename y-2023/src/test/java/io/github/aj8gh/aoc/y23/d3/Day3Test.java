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

@Disabled
class Day3Test extends InputProvider {

  private Day3 classUnderTest;

  @BeforeEach
  void setUp() {
    classUnderTest = new Day3();
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
    return getInput(4361, 0);
  }

  private static Stream<Arguments> inputProviderPart2() {
    return getInput(0, 0);
  }

  private static Stream<Arguments> getInput(int example, int result) {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_3).asStringList(), example),
        Arguments.of(reader().getInput(DAY_3).asStringList(), result)
    );
  }
}
