package io.github.aj8gh.aoc.y23.d2;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Day2 {

  private static final int FIRST = 1;
  private static final int RED = 12;
  private static final int GREEN = 13;
  private static final int BLUE = 14;
  private static final Pattern RED_PATTERN = Pattern.compile("(\\d+) red");
  private static final Pattern GREEN_PATTERN = Pattern.compile("(\\d+) green");
  private static final Pattern BLUE_PATTERN = Pattern.compile("(\\d+) blue");
  private static final Pattern DIGIT = Pattern.compile("(\\d+)");

  public int part1(List<String> input) {
    return input.stream()
        .map(this::toGame)
        .filter(this::isPossible)
        .map(Game::id)
        .reduce(0, Integer::sum);
  }

  public int part2(List<String> input) {
    return input.stream()
        .map(this::toGame)
        .map(Game::power)
        .reduce(0, Integer::sum);
  }

  private Game toGame(String line) {
    var split = line.split(":");
    return Game.builder()
        .id(getId(split[0]))
        .maxRed(getMaxRed(split[1]))
        .maxGreen(getMaxGreen(split[1]))
        .maxBlue(getMaxBlue(split[1]))
        .build();
  }

  private boolean isPossible(Game game) {
    return game.maxRed() <= RED
        && game.maxGreen() <= GREEN
        && game.maxBlue() <= BLUE;
  }

  private int getId(String s) {
    return getDigit(DIGIT, s);
  }

  private int getMaxRed(String rounds) {
    return getDigit(RED_PATTERN, rounds);
  }

  private int getMaxGreen(String rounds) {
    return getDigit(GREEN_PATTERN, rounds);
  }

  private int getMaxBlue(String rounds) {
    return getDigit(BLUE_PATTERN, rounds);
  }

  private int getDigit(Pattern pattern, String s) {
    return pattern
        .matcher(s)
        .results()
        .map(result -> result.group(FIRST))
        .mapToInt(Integer::parseInt)
        .max()
        .orElseThrow(NoSuchElementException::new);
  }
}
