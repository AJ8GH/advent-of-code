package io.github.aj8gh.aoc.y15.day5;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class NiceOMeter {
  private final Pattern naughtyPattern = Pattern.compile("ab|cd|pq|xy");
  private final Pattern vowelPattern = Pattern.compile(".*[aeiou].*[aeiou].*[aeiou].*");
  private final Pattern doublePattern = Pattern.compile("(.)\\1");
  private final Pattern repeatedDoublePattern = Pattern.compile("(.{2})(.*)\\1");
  private final Pattern sandwichPattern = Pattern.compile("(.)(.)\\1");

  public long analysePart1(List<String> strings) {
    return analyse(strings, this::isNice);
  }

  public long analysePart2(List<String> strings) {
    return analyse(strings, this::isNicePart2);
  }

  private long analyse(List<String> strings, Predicate<String> predicate) {
    return strings.stream().filter(predicate).count();
  }

  private boolean isNice(String string) {
    var naughtMatcher = naughtyPattern.matcher(string);
    var vowelMatcher = vowelPattern.matcher(string);
    var doubleMatcher = doublePattern.matcher(string);
    return !naughtMatcher.find() && vowelMatcher.find() && doubleMatcher.find();
  }

  private boolean isNicePart2(String string) {
    var repetitionMatcher = repeatedDoublePattern.matcher(string);
    var sandwichMatcher = sandwichPattern.matcher(string);
    return repetitionMatcher.find() && sandwichMatcher.find();
  }
}
