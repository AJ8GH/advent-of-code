package io.github.aj8gh.aoc.y23.d3;

import static java.lang.Integer.parseInt;

import java.util.List;
import java.util.regex.Pattern;

public class Day3 {

  private static final Pattern DIGIT = Pattern.compile("\\d");
  private static final Pattern SYMBOL = Pattern.compile("[^\\d|^.]");

  public int part1(List<List<String>> input) {
    var total = 0;

    for (int i = 0; i < input.size(); i++) {
      var row = input.get(i);
      for (int j = 0; j < row.size(); j++) {
        var point = row.get(j);
        if (DIGIT.matcher(point).find()) {
          var num = new StringBuilder(point);
          var newJ = j + 1;
          var next = row.get(newJ);
          while (DIGIT.matcher(next).find()) {
            num.append(next);
            if (newJ < row.size() - 1) {
              next = row.get(++newJ);
            } else {
              break;
            }
          }
          if (isAdjacent(input, i, j, newJ)) {
            total += parseInt(num.toString());
          }
          j = newJ;
        }
      }
    }

    return total;
  }

  public int part2(List<List<String>> input) {
    return 0;
  }

  private boolean isAdjacent(List<List<String>> input, int i, int j, int newJ) {
    if (j > 0 && isSymbol(input.get(i).get(j - 1))) {
      return true;
    }
    if (newJ < input.get(i).size() + 2 && isSymbol(input.get(i).get(newJ))) {
      return true;
    }
    var start = j > 0 ? j - 1 : j;
    for (int k = start; k <= newJ; k++) {
      if (i > 0 && isSymbol(input.get(i - 1).get(k))) {
        return true;
      }
      if (i < input.size() - 1 && isSymbol(input.get(i + 1).get(k))) {
        return true;
      }
    }
    return false;
  }

  private boolean isSymbol(String s) {
    return SYMBOL.matcher(s).find();
  }
}
