package io.github.aj8gh.aoc.y23.d3;

import static java.lang.Integer.parseInt;

import java.util.List;
import java.util.regex.Pattern;

public class Day3 {

  private static final GearMultiplier GEAR_MULTIPLIER = new GearMultiplier();
  private static final Pattern DIGIT = Pattern.compile("\\d");
  private static final Pattern SYMBOL = Pattern.compile("[^\\d|^.]");

  public int part1(List<List<String>> input) {
    var total = 0;

    for (int i = 0; i < input.size(); i++) {
      var row = input.get(i);
      for (int j = 0; j < row.size(); j++) {
        var point = row.get(j);
        if (isDigit(point)) {
          var num = findNum(row, j);
          var newJ = j + num.length();
          if (newJ == row.size()) {
            newJ--;
          }
          if (isAdjacent(input, i, j, newJ)) {
            total += parseInt(num);
          }
          j = newJ;
        }
      }
    }

    return total;
  }

  public int part2(List<List<String>> input) {
    return GEAR_MULTIPLIER.getTotal(input);
  }

  private boolean isAdjacent(List<List<String>> input, int i, int j, int newJ) {
    return isSideAdjacent(input, i, j, newJ) || isVerticalAdjacent(input, i, j, newJ);
  }

  private boolean isSideAdjacent(List<List<String>> input, int i, int j, int newJ) {
    return (j > 0 && isSymbol(input.get(i).get(j - 1)))
        || isSymbol(input.get(i).get(newJ));
  }

  private boolean isVerticalAdjacent(List<List<String>> input, int i, int j, int newJ) {
    for (int k = j > 0 ? j - 1 : j; k <= newJ; k++) {
      if (i > 0 && isSymbol(input.get(i - 1).get(k))
          || i < input.size() - 1 && isSymbol(input.get(i + 1).get(k))) {
        return true;
      }
    }
    return false;
  }

  private boolean isSymbol(String s) {
    return SYMBOL.matcher(s).find();
  }

  private boolean isDigit(String s) {
    return DIGIT.matcher(s).find();
  }

  private String findNum(List<String> row, int j) {
    var num = new StringBuilder(row.get(j));
    var newJ = j + 1;
    var next = row.get(newJ);
    while (isDigit(next)) {
      num.append(next);
      if (newJ < row.size() - 1) {
        next = row.get(++newJ);
      } else {
        break;
      }
    }
    return num.toString();
  }
}
