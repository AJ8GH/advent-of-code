package io.github.aj8gh.aoc.y21.day14;

import static java.util.stream.Collectors.groupingBy;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Polymer {

  private final Map<String, String> rules;
  private final String template;
  private final Map<String, Long> elementCount;
  private final Map<String, Long> polymerCount;
  private final Map<String, List<String>> insertionResults;

  public Polymer(Map<String, String> rules, String template) {
    this.rules = rules;
    this.template = template;
    this.elementCount = buildElementCount();
    this.polymerCount = buildPolymerCount();
    this.insertionResults = buildInsertionResults();
  }

  public long process(int steps) {
    var queue = new ArrayDeque<Map.Entry<String, Long>>();

    for (int i = 0; i < steps; i++) {
      for (var entry : polymerCount.entrySet()) {
        if (entry.getValue() > 0) {
          elementCount.merge(rules.get(entry.getKey()), entry.getValue(), Long::sum);
          queue.add(Map.Entry.copyOf(entry));
        }
      }

      while (!queue.isEmpty()) {
        var entry = queue.poll();
        polymerCount.merge(entry.getKey(), -entry.getValue(), Long::sum);
        for (var result : insertionResults.get(entry.getKey())) {
          polymerCount.merge(result, entry.getValue(), Long::sum);
        }
      }
    }

    var sortedValues = elementCount.values().stream()
        .mapToLong(Long::longValue)
        .sorted()
        .toArray();

    return sortedValues[sortedValues.length - 1] - sortedValues[0];
  }

  private Map<String, Long> buildElementCount() {
    return Arrays.stream(template.split(""))
        .collect(groupingBy(Function.identity(), Collectors.counting()));
  }

  private Map<String, Long> buildPolymerCount() {
    var map = new HashMap<String, Long>();
    for (int i = 0; i < template.length() - 1; i++) {
      var polymer = template.substring(i, i + 2);
      map.merge(polymer, 1L, Long::sum);
    }
    return map;
  }

  private Map<String, List<String>> buildInsertionResults() {
    var map = new HashMap<String, List<String>>();
    for (var e : rules.entrySet()) {
      var polymerSplit = e.getKey().split("");
      var result1 = polymerSplit[0] + e.getValue();
      var result2 = e.getValue() + polymerSplit[1];
      map.put(e.getKey(), List.of(result1, result2));
    }
    return map;
  }
}
