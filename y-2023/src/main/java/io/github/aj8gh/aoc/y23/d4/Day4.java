package io.github.aj8gh.aoc.y23.d4;

import static java.lang.Math.pow;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day4 {

  private static final Pattern CARD_PATTERN = Pattern.compile(".*\\d:\\s+(.*)\\s+\\|\\s+(.*)");
  private static final Pattern DIGITS = Pattern.compile("\\d+");
  private static final int FIRST = 1;
  private static final int SECOND = 2;

  public long part1(List<String> input) {
    return input.stream()
        .map(this::toScore)
        .reduce(0L, Long::sum);
  }

  public long part2(List<String> input) {
    return 0L;
  }

  private long toScore(String card) {
    var matcher = CARD_PATTERN.matcher(card);
    matcher.find();
    return (long) (pow(2, (toInts(matcher.group(FIRST))
        .stream()
        .filter(toInts(matcher.group(SECOND))::contains)
        .count() - 1)));
  }

  private List<Integer> toInts(String s) {
    return DIGITS.matcher(s)
        .results()
        .map(MatchResult::group)
        .map(Integer::parseInt)
        .toList();
  }
}
