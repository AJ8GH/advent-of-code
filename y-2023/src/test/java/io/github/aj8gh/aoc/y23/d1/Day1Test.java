package io.github.aj8gh.aoc.y23.d1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day1Test extends InputProvider {

  private Day1 subject;

  @BeforeEach
  void setUp() {
    subject = new Day1();
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(List<String> input, int expected) {
    var actual = subject.part1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(List<String> input, int expected) {
    var actual = subject.part2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return getInputPart1(142, 54644);
  }

  private static Stream<Arguments> inputProviderPart2() {
    return getInputPart2(281, 53348);
  }

  private static Stream<Arguments> getInputPart1(int example, int result) {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_1).asStringList(), example),
        Arguments.of(reader().getInput(DAY_1).asStringList(), result)
    );
  }

  private static Stream<Arguments> getInputPart2(int example, int result) {
    return Stream.of(
        Arguments.of(reader().getExample2(DAY_1).asStringList(), example),
        Arguments.of(reader().getInput(DAY_1).asStringList(), result)
    );
  }
}
