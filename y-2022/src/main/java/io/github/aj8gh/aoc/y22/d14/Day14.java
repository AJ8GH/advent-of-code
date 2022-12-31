package io.github.aj8gh.aoc.y22.d14;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Day14 {

  private static final int ENTRY = 500;
  private static final char ROCK = '#';
  private static final char EMPTY = '.';
  private static final char SAND = 'o';
  private static final char START = '+';

  private char[][] map;
  private int newEntry;
  private int offset;

  public int part1(List<List<String>> input) {
    var ints = parse(input);
    map = buildMap(ints);
    return 0;
  }

  public int part2(List<List<String>> input) {
    return 0;
  }

  private List<List<int[]>> parse(List<List<String>> input) {
    return input.stream().map(line -> line.stream().map(s -> Arrays.stream(s.split(","))
        .mapToInt(Integer::parseInt).toArray()).toList()).toList();
  }

  private char[][] buildMap(List<List<int[]>> input) {
    var i = getMax(input, 1) + 1;
    var j = getSize(input, 0) + 1;
    offset = getMin(input, 0);
    newEntry = ENTRY - offset;
    var output = new char[i][j];
    Arrays.stream(output).forEach(arr -> Arrays.fill(arr, EMPTY));
    mapRocks(input, output);
    return output;
  }

  private int getSize(List<List<int[]>> input, int i) {
    return getMax(input, i) - getMin(input, i);
  }

  private int getMax(List<List<int[]>> input, int i) {
    return asStream(input, i).max(Integer::compareTo).orElse(-1);
  }

  private int getMin(List<List<int[]>> input, int i) {
    return asStream(input, i).min(Integer::compareTo).orElse(-1);
  }

  private Stream<Integer> asStream(List<List<int[]>> input, int i) {
    return input.stream().flatMap(Collection::stream).map(arr -> arr[i]);
  }

  private void mapRocks(List<List<int[]>> input, char[][] output) {
    for (var line : input) {
      for (int i = 0; i < line.size() - 1; i++) {
        var first = line.get(i);
        var second = line.get(i + 1);
        var i1 = first[1];
        var i2 = second[1];
        var j1 = first[0] - offset;
        var j2 = second[0] - offset;

        for (int j = Math.min(j1, j2); j <= Math.max(j1, j2); j++) {
          output[i1][j] = ROCK;
        }
        for (int j = Math.min(i1, i2); j <= Math.max(i1, i2); j++) {
          output[j][j2] = ROCK;
        }
      }
    }
  }
}
