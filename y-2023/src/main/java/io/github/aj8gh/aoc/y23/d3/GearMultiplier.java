package io.github.aj8gh.aoc.y23.d3;

import static java.util.Map.entry;
import static java.util.function.Predicate.not;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class GearMultiplier {

  private static final String GEAR = "*";
  private static final Pattern DIGIT = Pattern.compile("\\d");

  public int getTotal(List<List<String>> input) {
    var total = 0;

    for (int i = 0; i < input.size(); i++) {
      var row = input.get(i);
      for (int j = 0; j < row.size(); j++) {
        var point = row.get(j);
        if (isGear(point)) {
          var adjacent = getAdjacents(input, i, j);
          if (adjacent.size() == 2) {
            total += adjacent.stream()
                .mapToInt(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);
          }
        }
      }
    }

    return total;
  }

  private List<String> getAdjacents(List<List<String>> input, int i, int j) {
    return Stream.of(
            getAdjacentNums(input, i - 1, j),
            getAdjacentNums(input, i, j),
            getAdjacentNums(input, i + 1, j))
        .flatMap(Collection::stream)
        .filter(not(String::isEmpty))
        .toList();
  }

  private List<String> getAdjacentNums(List<List<String>> input, int i, int j) {
    var adjacent = new ArrayList<String>();
    var numEntry = findStartNum(input, i, j - 1);
    var newJ = j;
    if (numEntry.getKey() >= 0) {
      adjacent.add(numEntry.getValue());
      newJ = numEntry.getKey() + numEntry.getValue().length();
    }
    while (newJ <= j + 1) {
      if (isDigit(input.get(i).get(newJ))) {
        var num = findNum(input.get(i), newJ);
        adjacent.add(num);
        newJ += num.length();
        continue;
      }
      newJ++;
    }
    return adjacent;
  }

  private Entry<Integer, String> findStartNum(List<List<String>> input, int i, int j) {
    if (i >= 0 && i < input.size() && j >= 0) {
      var row = input.get(i);
      var point = row.get(j);
      if (isDigit(point)) {
        j = findStartIndex(row, j);
        return entry(j, findNum(row, j));
      }
    }
    return entry(-1, "");
  }

  private int findStartIndex(List<String> row, int j) {
    var current = row.get(j);
    while (j > 0 && isDigit(current)) {
      current = row.get(--j);
    }
    return isDigit(current) ? j : ++j;
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


  private boolean isDigit(String s) {
    return DIGIT.matcher(s).find();
  }

  private boolean isGear(String s) {
    return GEAR.equals(s);
  }
}
