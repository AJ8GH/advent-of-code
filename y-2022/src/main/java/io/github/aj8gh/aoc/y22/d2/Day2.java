package io.github.aj8gh.aoc.y22.d2;

import java.util.List;
import java.util.Map;

public class Day2 {
  private static final Map<Character, Map<Character, Integer>> RESULT_MAP_1 = Map.of(
      'A', Map.of('X', 4, 'Y', 8, 'Z', 3),
      'B', Map.of('X', 1, 'Y', 5, 'Z', 9),
      'C', Map.of('X', 7, 'Y', 2, 'Z', 6)
  );

  private static final Map<Character, Map<Character, Integer>> RESULT_MAP_2 = Map.of(
      'A', Map.of('X', 3, 'Y', 4, 'Z', 8),
      'B', Map.of('X', 1, 'Y', 5, 'Z', 9),
      'C', Map.of('X', 2, 'Y', 6, 'Z', 7)
  );

  public int part1(List<String> input) {
    return calculate(input, RESULT_MAP_1);
  }

  public int part2(List<String> input) {
    return calculate(input, RESULT_MAP_2);
  }

  private int calculate(List<String> input, Map<Character, Map<Character, Integer>> resultMap) {
    return input.stream()
        .map(s -> resultMap.get(s.charAt(0)).get(s.charAt(2)))
        .reduce(0, Integer::sum);
  }
}
