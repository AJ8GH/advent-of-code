package io.github.aj8gh.aoc.y23.d4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day4Test extends InputProvider {

  private Day4 subject;

  @BeforeEach
  void setUp() {
    subject = new Day4();
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(List<String> input, long expected) {
    var actual = subject.part1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(List<String> input, long expected) {
    var actual = subject.part2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return getInput(13L, 24175L);
  }

  private static Stream<Arguments> inputProviderPart2() {
    return getInput(30L, 18846301L);
  }

  private static Stream<Arguments> getInput(long example, long result) {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_4).asStringList(), example),
        Arguments.of(reader().getInput(DAY_4).asStringList(), result)
    );
  }
}
