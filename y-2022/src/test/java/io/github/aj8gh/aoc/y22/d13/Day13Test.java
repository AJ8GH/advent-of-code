package io.github.aj8gh.aoc.y22.d13;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day13Test extends InputProvider {

  private Day13 subject;

  @BeforeEach
  void setUp() {
    subject = new Day13();
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
    return Stream.concat(getInput(13, 4643), getAdditionalExamples(43, 177, 4, 180));
  }

  private static Stream<Arguments> inputProviderPart2() {
    return getInput(140, 21614);
  }

  private static Stream<Arguments> getInput(int example, int result) {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_13).asStringList(), example),
        Arguments.of(reader().getInput(DAY_13).asStringList(), result)
    );
  }

  private static Stream<Arguments> getAdditionalExamples(int... examples) {
    return Stream.of(
        Arguments.of(reader().getExample2(DAY_13).asStringList(), examples[0]),
        Arguments.of(reader().getExample3(DAY_13).asStringList(), examples[1]),
        Arguments.of(reader().getExample4(DAY_13).asStringList(), examples[2]),
        Arguments.of(reader().getExample5(DAY_13).asStringList(), examples[3])
    );
  }
}
