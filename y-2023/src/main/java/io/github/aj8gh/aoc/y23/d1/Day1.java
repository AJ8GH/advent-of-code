package io.github.aj8gh.aoc.y23.d1;

import static java.lang.Integer.parseInt;
import static java.lang.String.join;
import static java.util.regex.Pattern.compile;
import static java.util.stream.Collectors.joining;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day1 {

  private static final Map<String, String> NUMBERS = Map.of(
      "one", "1",
      "two", "2",
      "three", "3",
      "four", "4",
      "five", "5",
      "six", "6",
      "seven", "7",
      "eight", "8",
      "nine", "9"
  );

  private static final int FIRST = 1;
  private static final List<Pattern> PATTERNS = List.of(
      compile("\\D?(\\d).*"),
      compile(".*(\\d)\\D?")
  );

  private static final List<Pattern> WORD_PATTERNS = List.of(
      compile("\\D?(\\d|" + join("|", NUMBERS.keySet()) + ").*"),
      compile(".*(\\d|" + join("|", NUMBERS.keySet()) + ")\\D?")
  );

  public int part1(List<String> input) {
    return getTotal(input, PATTERNS);
  }

  public int part2(List<String> input) {
    return getTotal(input, WORD_PATTERNS);
  }

  private int getTotal(List<String> input, List<Pattern> patterns) {
    return input.stream()
        .mapToInt(line -> toInt(line, patterns))
        .reduce(0, Integer::sum);
  }

  private int toInt(String line, List<Pattern> patterns) {
    return parseInt(patterns
        .stream()
        .map(pattern -> match(pattern, line))
        .map(this::fromWord)
        .collect(joining()));
  }

  private String match(Pattern pattern, String line) {
    var matcher = pattern.matcher(line);
    if (matcher.find()) {
      return matcher.group(FIRST);
    }
    log.warn("No match, {}, {}", pattern, line);
    return "";
  }

  private String fromWord(String s) {
    return NUMBERS.getOrDefault(s, s);
  }
}
