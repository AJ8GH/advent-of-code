package io.github.aj8gh.aoc.y21.d8;

import java.util.List;
import java.util.Set;

public class DigitParser {
  private static final Set<Integer> UNIQUE_SEGMENTS = Set.of(2, 3, 4, 7);

  public int getTotalOutput(List<String> input) {
    var entries = toEntries(input);
    return entries.stream().map(e -> {
      StringBuilder outputString = new StringBuilder();
      for (String digit : e.getOutput()) {
        outputString.append(e.getDigitValue(digit));
      }
      return Integer.parseInt(outputString.toString());
    }).reduce(Integer::sum).orElse(-1);
  }

  public int getUniqueDigitCount(List<String> input) {
    var entries = toEntries(input);
    int uniqueDigitCount = 0;
    for (Entry entry : entries) {
      uniqueDigitCount += entry.getOutput()
          .stream()
          .filter(d -> UNIQUE_SEGMENTS.contains(d.length()))
          .count();
    }
    return uniqueDigitCount;
  }

  private List<Entry> toEntries(List<String> input) {
    return input.stream().map(line -> {
      var split = line.split(" \\| ");
      return new Entry(split[0], split[1]);
    }).toList();
  }
}
