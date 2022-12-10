package io.github.aj8gh.aoc.y22.d4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Day4 {
  public int part1(List<String> input) {
    return process(input, this::isContained);
  }

  public int part2(List<String> input) {
    return process(input, this::isOverlapping);
  }

  private int process(List<String> input, Predicate<List<List<Integer>>> predicate) {
    return (int) input.stream()
        .map(line -> Arrays.stream(line.split(","))
            .map(s -> Arrays.stream(s.split("-"))
                .map(Integer::parseInt).toList()).toList())
        .filter(predicate)
        .count();
  }

  private boolean isContained(List<List<Integer>> line) {
    return isContained(line.get(0), line.get(1)) || isContained(line.get(1), line.get(0));
  }

  boolean isContained(List<Integer> l1, List<Integer> l2) {
    return l1.get(0) >= l2.get(0) && l1.get(1) <= l2.get(1);
  }

  private boolean isOverlapping(List<List<Integer>> line) {
    return isOverlapping(line.get(0), line.get(1)) || isOverlapping(line.get(1), line.get(0));
  }

  private boolean isOverlapping(List<Integer> l1, List<Integer> l2) {
    return (l1.get(0) >= l2.get(0) && l1.get(0) <= l2.get(1))
        || (l1.get(1) >= l2.get(0) && l1.get(1) <= l2.get(1));
  }
}
