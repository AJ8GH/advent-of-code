package io.github.aj8gh.aoc.y21.d10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class SyntaxCheckerTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day10Part1(List<String> input, int expected) {
    var syntaxChecker = new SyntaxChecker();
    var actual = syntaxChecker.getCorruptedScore(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void day10Part2(List<String> input, long expected) {
    var syntaxChecker = new SyntaxChecker();
    var actual = syntaxChecker.getMiddleCompletionScore(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_10).asStringList(), 26397),
        Arguments.of(reader().getInput(DAY_10).asStringList(), 462693)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_10).asStringList(), 288957L),
        Arguments.of(reader().getInput(DAY_10).asStringList(), 3094671161L)
    );
  }
}
