package io.github.aj8gh.aoc.y15.day8;

import java.util.List;
import java.util.function.ToIntFunction;

public class CodeParser {

  public int parsePart1(List<String> lines) {
    return parse(lines, line -> line.length() - countStringChars(line));
  }

  public int parsePart2(List<String> lines) {
    return parse(lines, line -> encodedLength(line) - line.length());
  }

  private int parse(List<String> lines, ToIntFunction<String> function) {
    return lines.stream().map(function::applyAsInt).reduce(0, Integer::sum);
  }

  private int countStringChars(String line) {
    int chars = 0;
    for (int i = 0; i < line.length(); i++) {
      chars++;
      var letter = line.charAt(i);
      if (letter == '\\') {
        i += line.charAt(i + 1) == 'x' ? 3 : 1;
      }
    }
    return chars - 2;
  }

  private int encodedLength(String line) {
    int chars = 0;
    for (int i = 0; i < line.length(); i++) {
      chars++;
      var letter = line.charAt(i);
      if (letter == '\\' || letter == '"') {
        chars++;
      }
    }
    return chars + 2;
  }
}
