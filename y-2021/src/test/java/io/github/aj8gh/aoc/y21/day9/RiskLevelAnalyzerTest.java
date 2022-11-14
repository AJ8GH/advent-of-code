package io.github.aj8gh.aoc.y21.day9;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class RiskLevelAnalyzerTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day9part1(List<String> input, int expected) {
    var riskLevelAnalyzer = new RiskLevelAnalyzer();
    var actual = riskLevelAnalyzer.calculateScore(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void day9part2(List<String> input, int expected) {
    var riskLevelAnalyzer = new RiskLevelAnalyzer();
    var actual = riskLevelAnalyzer.getLargestBasinsFactor(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_9).asStringList(), 15),
        Arguments.of(reader().getInput(DAY_9).asStringList(), 580)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_9).asStringList(), 1134),
        Arguments.of(reader().getInput(DAY_9).asStringList(), 856716)
    );
  }
}
