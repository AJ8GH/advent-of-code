package io.github.aj8gh.aoc.y21.day14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  private static final String EXAMPLE = "./src/main/resources/io.github.aj8gh.aoc.y21.day14/example.txt";
  private static final String INPUT = "./src/main/resources/io.github.aj8gh.aoc.y21.day14/input.txt";

  public static void main(String[] args) {
    // part 1
    var polymer = deserialize(EXAMPLE);
    var solution = polymer.process(10);
    log.info("Example 1: {}", solution);
    assert solution == 1588L;

    polymer = deserialize(EXAMPLE);
    solution = polymer.process(40);
    log.info("Example 2: {}", solution);
    assert solution == 2188189693529L;

    // part 2
    polymer = deserialize(INPUT);
    solution = polymer.process(10);
    log.info("Example 2: {}", solution);
    assert solution == 2435L;

    polymer = deserialize(INPUT);
    solution = polymer.process(40);
    log.info("Example 2: {}", solution);
    assert solution == 2435L;

  }

  private static PolymerTool deserialize(String filePath) {
    Map<String, String> rules = new HashMap<>();
    Node template = null;
    try (var reader = new BufferedReader(new FileReader(filePath))) {
      String t = reader.readLine();
      var tSplit = t.split("");
      template = new Node(tSplit[0]);
      Node current = template;
      for (int i = 1; i < tSplit.length; i++) {
        Node next = new Node(tSplit[i]);
        current.setNext(next);
        next.setPrevious(current);
        current = next;
      }
      String line;
      while ((line = reader.readLine()) != null) {
        if (line.isEmpty()) {
          continue;
        }
        String[] pair = line.split(" -> ");
        rules.put(pair[0], pair[1]);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new PolymerTool(rules, template);
  }
}
