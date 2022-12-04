package io.github.aj8gh.aoc.y22.d4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Day4 {
  public int part1(List<String> input) {
    return process(input, this::isFullyOverlapping);
  }

  public int part2(List<String> input) {
    return process(input, this::isOverlappingAtAll);
  }

  private int process(List<String> input, Predicate<List<List<Integer>>> predicate) {
    return (int) input.stream()
        .map(line -> Arrays.stream(line.split(","))
            .map(s -> Arrays.stream(s.split("-"))
                .map(Integer::parseInt).toList()).toList())
        .filter(predicate)
        .count();
  }

  private boolean isFullyOverlapping(List<List<Integer>> line) {
    return (line.get(0).get(0) >= line.get(1).get(0) && line.get(0).get(1) <= line.get(1).get(1))
        || (line.get(1).get(0) >= line.get(0).get(0) && line.get(1).get(1) <= line.get(0).get(1));
  }

  private boolean isOverlappingAtAll(List<List<Integer>> line) {
    return (line.get(0).get(0) >= line.get(1).get(0) && line.get(0).get(0) <= line.get(1).get(1))
        || (line.get(0).get(1) >= line.get(1).get(0) && line.get(0).get(1) <= line.get(1).get(1))
        || (line.get(1).get(0) >= line.get(0).get(0) && line.get(1).get(0) <= line.get(0).get(1))
        || (line.get(1).get(1) >= line.get(0).get(0) && line.get(1).get(1) <= line.get(0).get(1));
  }
}
