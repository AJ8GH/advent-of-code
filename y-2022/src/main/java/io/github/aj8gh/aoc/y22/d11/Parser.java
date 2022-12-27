package io.github.aj8gh.aoc.y22.d11;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.ToLongBiFunction;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Parser {

  private static final String OLD = "old";
  private static final String ADD = "+";
  private static final String MULTIPLY = "*";
  private static final String SUBTRACT = "-";
  private static final String DIVIDE = "/";
  private static final Pattern DIGIT = Pattern.compile("\\d+");
  private static final Pattern OPERATOR = Pattern.compile("[+\\-/*]");
  private static final Pattern OPERAND = Pattern.compile("(old|\\d+)$");
  private static final Map<String, ToLongBiFunction<Long, Long>> OPS = Map.of(
      OLD, (a, b) -> (long) Math.pow(a, b),
      SUBTRACT, (a, b) -> a - b,
      MULTIPLY, (a, b) -> a * b,
      DIVIDE, (a, b) -> a / b,
      ADD, Long::sum
  );

  static List<Monkey> parse(List<String> input) {
    var monkeys = new ArrayList<Monkey>();
    for (int i = 0; i < input.size(); i += 7) {
      var items = new ArrayDeque<>(getDigits(input.get(i + 1)));
      var op = getString(OPERAND.matcher(input.get(i + 2)));
      var operator = op.equals(OLD) ? OLD : getString(OPERATOR.matcher((input.get(i + 2))));
      var operand = op.equals(OLD) ? 2 : getDigit(input.get(i + 2));
      var test = getDigit(input.get(i + 3));
      var ifTrue = getDigit(input.get(i + 4));
      var ifFalse = getDigit(input.get(i + 5));
      monkeys.add(new Monkey(items, OPS.get(operator), operand, test, ifTrue, ifFalse));
    }
    var cycle = monkeys.stream().map(Monkey::getTestNumber).reduce(1L, (a, b) -> a * b);
    monkeys.forEach(m -> m.setCycle(cycle));
    return monkeys;
  }


  private static Long getDigit(String line) {
    return getLongStream(line).findFirst().orElse(-1L);
  }

  private static List<Long> getDigits(String line) {
    return getLongStream(line).toList();
  }

  private static Stream<Long> getLongStream(String line) {
    return DIGIT.matcher(line).results().map(result -> Long.parseLong(result.group()));
  }

  private static String getString(Matcher matcher) {
    return matcher.results().map(MatchResult::group).findFirst().orElse("");
  }
}
