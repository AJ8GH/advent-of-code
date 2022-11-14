package io.github.aj8gh.aoc.y15.d1;

public class DirectionParser {

  public int getFloor(String input) {
    var result = 0;
    for (var p : input.split("")) {
      result += p.equals("(") ? 1 : -1;
    }
    return result;
  }

  public int getNegativePosition(String input) {
    var result = 0;
    for (int i = 0; i < input.length(); i++) {
      result += input.charAt(i) == ('(') ? 1 : -1;
      if (result == -1) {
        return i + 1;
      }
    }
    return -1;
  }
}
