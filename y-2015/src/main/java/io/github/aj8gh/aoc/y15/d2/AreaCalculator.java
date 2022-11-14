package io.github.aj8gh.aoc.y15.d2;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;

public class AreaCalculator {

  private static final String DELIMITER = "x";

  public int calculatePaper(List<String> dimensions) {
    return calculate(dimensions, this::getPaperArea);
  }

  public int calculateRibbon(List<String> dimensions) {
    return calculate(dimensions, this::getRibbonLength);
  }

  private int calculate(List<String> dimensions, ToIntFunction<List<Integer>> function) {
    return dimensions.stream()
        .map(line -> function.applyAsInt(Arrays.stream(line.split(DELIMITER))
            .map(Integer::parseInt)
            .toList()))
        .mapToInt(Integer::intValue)
        .reduce(0, Integer::sum);
  }

  private int getPaperArea(List<Integer> list) {
    var sides = getAreas(list);
    return 2 * sides.stream().reduce(0, Integer::sum) + getMin(sides);
  }

  private int getRibbonLength(List<Integer> list) {
    Integer volume = list.stream().reduce(1, (i, j) -> i * j);
    var sorted = list.stream().sorted().toList();
    var minPerim = 2 * (sorted.get(0) + sorted.get(1));
    return minPerim + volume;
  }

  private List<Integer> getAreas(List<Integer> list) {
    return List.of(
        list.get(0) * list.get(1),
        list.get(1) * list.get(2),
        list.get(2) * list.get(0));
  }

  private int getMin(List<Integer> ints) {
    return Math.min(ints.get(0), Math.min(ints.get(1), ints.get(2)));
  }
}
