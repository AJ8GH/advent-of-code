package io.github.aj8gh.aoc.y22.d14;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day14 {

  private static final int ENTRY = 500;
  private static final String ROCK = "#";
  private static final String EMPTY = ".";
  private static final String SAND = "o";
  private static final String START = "+";

  private String[][] map;
  private int[] newEntry;
  private int offset;
  private boolean done;
  private int count;

  public int part1(List<List<String>> input) {
    var ints = parse(input);
    map = buildMap(ints, false);
    model();
    return count;
  }

  public int part2(List<List<String>> input) {
    var ints = parse(input);
    map = buildMap(ints, true);
    model();
    return count;
  }

  private void model() {
    var next = newEntry;
    while (!done) {
      var newNext = getNext(next);
      if (newNext.length == 0) {
        if (done) {
          break;
        }
        map[next[0]][next[1]] = SAND;
        count++;
        if (next[0] == newEntry[0] && next[1] == newEntry[1]) {
          done = true;
        }
        next = newEntry;
      } else {
        next = newNext;
      }
    }
  }


  private int[] getNext(int[] next) {
    var newNext = new int[][] {
        {next[0] + 1, next[1]},
        {next[0] + 1, next[1] - 1},
        {next[0] + 1, next[1] + 1}
    };
    for (var n : newNext) {
      if (n[0] < map.length && n[1] >= 0 && n[1] < map[n[0]].length) {
        if (map[n[0]][n[1]].equals(".")) {
          return n;
        }
      } else {
        done = true;
        break;
      }
    }
    return new int[0];
  }

  private List<List<int[]>> parse(List<List<String>> input) {
    return input.stream().map(line -> line.stream().map(s -> Arrays.stream(s.split(","))
        .mapToInt(Integer::parseInt).toArray()).toList()).toList();
  }

  private String[][] buildMap(List<List<int[]>> input, boolean part2) {
    var rows = getMax(input, 1) + (part2 ? 3 : 1);
    var cols = part2 ? (getMax(input, 0) + 1) * 2 : getMax(input, 0) - getMin(input) + 1;
    offset = part2 ? 0 : getMin(input);
    newEntry = new int[] {0, ENTRY - offset};
    var output = new String[rows][cols];
    Arrays.stream(output).forEach(arr -> Arrays.fill(arr, EMPTY));
    mapRocks(input, output, part2);
    output[newEntry[0]][newEntry[1]] = START;
    return output;
  }

  private int getMax(List<List<int[]>> input, int i) {
    return asStream(input, i).max(Integer::compareTo).orElse(-1);
  }

  private int getMin(List<List<int[]>> input) {
    return asStream(input, 0).min(Integer::compareTo).orElse(-1);
  }

  private Stream<Integer> asStream(List<List<int[]>> input, int i) {
    return input.stream().flatMap(Collection::stream).map(arr -> arr[i]);
  }

  private void mapRocks(List<List<int[]>> input, String[][] output, boolean part2) {
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
    if (part2) {
      Arrays.fill(output[output.length - 1], ROCK);
    }
  }
}
