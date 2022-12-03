package io.github.aj8gh.aoc.y22.d1;

import java.util.Comparator;
import java.util.List;

public class Day1 {
  public int part1(List<List<Integer>> input) {
    return input.stream()
        .mapToInt(l -> l.stream().reduce(0, Integer::sum))
        .max().orElse(-1);
  }

  public int part2(List<List<Integer>> input) {
    return input.stream()
        .map(l -> l.stream().reduce(0, Integer::sum))
        .sorted(Comparator.reverseOrder())
        .limit(3)
        .reduce(0, Integer::sum);
  }
}
