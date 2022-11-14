package io.github.aj8gh.aoc.y21.d3;

import java.util.ArrayList;
import java.util.List;

public class DiagnosticReader {
  private static final char ONE = '1';
  private static final char ZERO = '0';

  public int readPart1(List<String> input) {
    int zeros;
    int ones;
    StringBuilder gammaSb = new StringBuilder();
    StringBuilder epsilonSb = new StringBuilder();

    for (int i = 0; i < input.get(0).length(); i++) {
      zeros = 0;
      ones = 0;
      for (String binary : input) {
        if (binary.charAt(i) == ZERO) {
          zeros++;
        }
        if (binary.charAt(i) == ONE) {
          ones++;
        }
      }
      gammaSb.append(zeros > ones ? 0 : 1);
      epsilonSb.append(zeros > ones ? 1 : 0);
    }

    int gammaDec = Integer.parseInt(gammaSb.toString(), 2);
    int epsilonDec = Integer.parseInt(epsilonSb.toString(), 2);

    return epsilonDec * gammaDec;
  }

  public int readPart2(List<String> input) {
    return getGen(input, true) * getGen(input, false);
  }

  public int getGen(List<String> input, boolean oxygen) {
    var filteredList = new ArrayList<>(input);
    for (int i = 0; i < input.get(0).length(); i++) {
      int finalI = i;
      int zeros = 0;
      int ones = 0;
      for (String binary : filteredList) {
        if (binary.charAt(i) == ONE) {
          ones++;
        }
        if (binary.charAt(i) == ZERO) {
          zeros++;
        }
      }
      if (ones >= zeros) {
        filteredList.removeIf(s -> s.charAt(finalI) != (oxygen ? ONE : ZERO));
      } else {
        filteredList.removeIf(s -> s.charAt(finalI) != (oxygen ? ZERO : ONE));
      }
      if (filteredList.size() == 1) {
        break;
      }
    }
    return Integer.parseInt(filteredList.get(0), 2);
  }
}
