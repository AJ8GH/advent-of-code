package io.github.aj8gh.aoc.y15.d1;

import java.util.Arrays;

public class DirectionParser {

  public int getFloor(String input) {
    return Arrays.stream(input.split(""))
        .map(e -> e.equals("(") ? 1 : -1)
        .reduce(0, Integer::sum);
  }

  public int getNegativePosition(String input) {
    var result = 0;
    for (int i = 0; i < input.length(); i++) {
      result += input.charAt(i) == ('(') ? 1 : -1;
      if (result < 0) {
        return i + 1;
      }
    }
    throw new AssertionError("No negative position");
  }
}
