package io.github.aj8gh.aoc.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Input {
  private final Stream<String> result;

  public Input(Stream<String> result) {
    this.result = result;
  }

  public String asString() {
    return String.join("", result.toList());
  }

  public List<String> asStringList() {
    return new ArrayList<>(result.toList());
  }

  public List<String> asStringList(String delimiter) {
    return asNestedStringList(delimiter).get(0);
  }

  public String[] asStringArray() {
    return result.toArray(String[]::new);
  }

  public String[] asStringArray(String delimiter) {
    return asNestedStringArray(delimiter)[0];
  }

  public List<List<String>> asNestedStringList(String delimiter) {
    return new ArrayList<>(result
        .map(s -> new ArrayList<>(Arrays.stream(s.split(delimiter)).toList()))
        .toList());
  }

  public List<Integer> asIntList() {
    return new ArrayList<>(result.map(Integer::parseInt).toList());
  }

  public List<Integer> asIntList(String delimiter) {
    return asNestedIntList(delimiter).get(0);
  }

  public int[] asIntArray() {
    return result.mapToInt(Integer::parseInt).toArray();
  }

  public int[] asIntArray(String delimiter) {
    return asNestedIntArray(delimiter)[0];
  }

  public List<List<Integer>> asNestedIntList(String delimiter) {
    return new ArrayList<>(result.map(s -> new ArrayList<>(Arrays.stream(s.split(delimiter))
            .map(Integer::parseInt).toList()))
        .toList());
  }

  public int[][] asNestedIntArray(String delimiter) {
    return result.map(s -> Arrays.stream(s.split(delimiter)).mapToInt(Integer::parseInt).toArray())
        .toArray(int[][]::new);
  }

  public String[][] asNestedStringArray(String delimiter) {
    return result.map(s -> Arrays.stream(s.split(delimiter)).toArray(String[]::new))
        .toArray(String[][]::new);
  }
}
