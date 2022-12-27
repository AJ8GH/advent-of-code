package io.github.aj8gh.aoc.y22.d10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.github.aj8gh.aoc.util.InputProvider;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Day10Test extends InputProvider {

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_1)
  void part1(List<String> input, int expected) {
    var day10 = new Day10();
    var actual = day10.part1(input);
    assertEquals(expected, actual);
  }

  @ParameterizedTest
  @MethodSource(value = INPUT_PROVIDER_PART_2)
  void part2(List<String> input, String expected) {
    var day10 = new Day10();
    var actual = day10.part2(input);
    assertEquals(expected, actual);
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_10).asStringList(), 13140),
        Arguments.of(reader().getInput(DAY_10).asStringList(), 14540)
    );
  }

  private static Stream<Arguments> inputProviderPart2() {
    return Stream.of(
        Arguments.of(reader().getExample(DAY_10).asStringList(), """
            ##..##..##..##..##..##..##..##..##..##..
            ###...###...###...###...###...###...###.
            ####....####....####....####....####....
            #####.....#####.....#####.....#####.....
            ######......######......######......####
            #######.......#######.......#######....."""),
        Arguments.of(reader().getInput(DAY_10).asStringList(), """
            ####.#..#.####.####.####.#..#..##..####.
            #....#..#....#.#.......#.#..#.#..#....#.
            ###..####...#..###....#..####.#......#..
            #....#..#..#...#.....#...#..#.#.....#...
            #....#..#.#....#....#....#..#.#..#.#....
            ####.#..#.####.#....####.#..#..##..####.""")
    );
  }
}
