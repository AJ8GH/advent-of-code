package io.github.aj8gh.aoc.y21.day14;

import java.util.HashMap;
import java.util.Map;

public class PolymerTool {

  private final Map<String, String> rules;
  private final Node template;

  public PolymerTool(Map<String, String> rules, Node template) {
    this.rules = rules;
    this.template = template;
  }

  public long process(int steps) {
    for (int i = 0; i < steps; i++) {

      var current = template;
      while (current != null) {
        var previous = current.getPrevious();

        if (previous == null) {
          current = current.getNext();
          continue;
        }

        var insert = rules.get(previous.getValue() + current.getValue());
        if (insert != null) {
          var insertNode = new Node(insert);
          previous.setNext(insertNode);
          insertNode.setPrevious(previous);
          insertNode.setNext(current);
          current.setPrevious(insertNode);
        }
        current = current.getNext();
      }
    }
    return getCount();
  }

  public long getCount() {
    var count = new HashMap<String, Integer>();
    var current = template;
    while (current != null) {
      count.merge(current.getValue(), 1, Integer::sum);
      current = current.getNext();
    }
    var sorted = count.values().stream().sorted().toList();
    return sorted.get(sorted.size() - 1) - sorted.get(0);
  }
}
