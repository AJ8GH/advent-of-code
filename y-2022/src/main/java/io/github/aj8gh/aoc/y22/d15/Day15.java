package io.github.aj8gh.aoc.y22.d15;

import static java.lang.Math.abs;
import static java.util.stream.IntStream.range;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day15 {

  private static final Pattern PATTERN = Pattern.compile("-?\\d+");
  private static final long MULTIPLIER = 4_000_000;
  private List<List<Integer>> digits;
  private Set<List<Integer>> beacons;
  private Set<List<Integer>> sensors;

  public long part1(List<String> input, int rowToCheck) {
    parse(input);
    var maxDiff = Collections.max(digits.stream().map(this::getDiff).toList());
    var rowDigits = getBeacons(digits);
    var maxX = Collections.max(rowDigits);
    var minX = Collections.min(rowDigits);

    return range(minX - maxDiff, maxX + maxDiff)
        .filter(i -> isNotBeacon(i, rowToCheck) && isCovered(i, rowToCheck))
        .count();
  }

  public long part2(List<String> input, int max) {
    parse(input);
    for (int i = 0; i <= max; i++) {
      for (int j = 0; j <= max; j++) {
        if (isNotBeacon(i, j) && !isSensor(i, j) && !isCovered(i, j)) {
          return i * MULTIPLIER + j;
        }
      }
    }
    return -1;
  }

  private void parse(List<String> input) {
    digits = input.stream()
        .map(line -> PATTERN.matcher(line).results()
            .map(MatchResult::group)
            .map(Integer::parseInt).toList())
        .toList();

    beacons = extract(2, 4);
    sensors = extract(0, 2);
  }

  private boolean isCovered(int x, int rowToCheck) {
    for (var line : digits) {
      var diffX = abs(line.get(0) - line.get(2));
      var diffY = abs(line.get(1) - line.get(3));
      var diff = diffX + diffY;

      var newDiffY = abs(line.get(1) - rowToCheck);
      var newDiffX = abs(line.get(0) - x);
      if (newDiffX + newDiffY <= diff) {
        return true;
      }
    }
    return false;
  }

  private boolean isNotBeacon(int x, int rowToCheck) {
    return !beacons.contains(List.of(x, rowToCheck));
  }

  private boolean isSensor(int x, int rowToCheck) {
    return sensors.contains(List.of(x, rowToCheck));
  }

  private List<Integer> getBeacons(List<List<Integer>> digits) {
    return digits.stream()
        .map(line -> List.of(line.get(0), line.get(2)))
        .flatMap(List::stream)
        .toList();
  }

  private int getDiff(List<Integer> line) {
    return abs(line.get(0) - line.get(2));
  }

  private Set<List<Integer>> extract(int a, int b) {
    return new HashSet<>(digits.stream().map(line -> line.subList(a, b)).toList());
  }
}
