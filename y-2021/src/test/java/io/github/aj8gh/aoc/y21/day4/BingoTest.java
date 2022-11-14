package io.github.aj8gh.aoc.y21.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BingoTest extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void day4part1(List<String> input, int expected) {
    var bingo = new Bingo();
    var actual = bingo.findFirstToWin(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void day4part2(List<String> input, int expected) {
    var bingo = new Bingo();
    var actual = bingo.findLastToWin(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_4).asStringList(), 4512),
        Arguments.of(reader().getInput(DAY_4).asStringList(), 50008)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_4).asStringList(), 1924),
        Arguments.of(reader().getInput(DAY_4).asStringList(), 17408)
    );
  }
}
