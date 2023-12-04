package io.github.aj8gh.aoc.y23.d4;

import static java.lang.Math.pow;
import static java.util.Collections.nCopies;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day4 {

  private static final Pattern NUMBER_PATTERN = Pattern.compile(".*\\d:\\s+(.*)\\s+\\|\\s+(.*)");
  private static final Pattern CARD_PATTERN = Pattern.compile("\\D+(\\d+).*");
  private static final Pattern DIGITS = Pattern.compile("\\d+");
  private static final int FIRST = 1;
  private static final int SECOND = 2;

  public long part1(List<String> input) {
    return input.stream()
        .map(this::toScore)
        .map(score -> (long) pow(2, score - 1d))
        .reduce(0L, Long::sum);
  }

  public long part2(List<String> input) {
    var counts = new ArrayList<>(nCopies(input.size(), 1));
    input.forEach(card -> count(card, counts));
    return counts.stream().reduce(0, Integer::sum);
  }

  private long toScore(String card) {
    var matcher = NUMBER_PATTERN.matcher(card);
    if (matcher.find()) {
      return toInts(matcher.group(FIRST))
          .stream()
          .filter(toInts(matcher.group(SECOND))::contains)
          .count();
    }
    throw new NoSuchElementException("Not found in " + card);
  }

  private List<Integer> toInts(String s) {
    return DIGITS.matcher(s)
        .results()
        .map(MatchResult::group)
        .map(Integer::parseInt)
        .toList();
  }

  private void count(String card, List<Integer> counts) {
    var cardNumber = getCardNumber(card);
    var thisCardCount = counts.get(cardNumber - 1);
    var score = toScore(card);

    for (int i = 0; i < thisCardCount; i++) {
      for (int j = cardNumber; j < cardNumber + score && j < counts.size(); j++) {
        counts.set(j, counts.get(j) + 1);
      }
    }
  }

  private int getCardNumber(String card) {
    return CARD_PATTERN.matcher(card)
        .results()
        .map(result -> result.group(FIRST))
        .findAny()
        .map(Integer::parseInt)
        .orElseThrow(NoSuchElementException::new);
  }
}
