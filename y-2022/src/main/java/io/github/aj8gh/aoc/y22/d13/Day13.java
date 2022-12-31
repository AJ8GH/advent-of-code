package io.github.aj8gh.aoc.y22.d13;

import static java.util.Collections.binarySearch;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day13 {
  private static final ObjectMapper MAPPER = new ObjectMapper();
  private static final List<String> DIVIDER_PACKETS = List.of("[[2]]", "[[6]]");
  private int correct;

  public int part1(List<String> input) {
    var tree = toNodes(input);
    for (int i = 0; i < tree.size() - 1; i += 2) {
      var first = tree.get(i);
      var second = tree.get(i + 1);
      if (first.compareTo(second) <= 0) {
        correct += i / 2 + 1;
      }
    }
    return correct;
  }

  public int part2(List<String> input) {
    input.addAll(DIVIDER_PACKETS);
    var tree = toNodes(input);
    tree.sort(Node::compareTo);

    return toNodes(DIVIDER_PACKETS).stream()
        .map(n -> binarySearch(tree, n) + 1)
        .reduce(1, (a, b) -> a * b);
  }

  private List<Node> toNodes(List<String> input) {
    return new ArrayList<>(input.stream()
        .filter(line -> !line.isBlank())
        .map(this::toNode)
        .toList());
  }

  private Node toNode(String line) {
    try {
      return new Node(MAPPER.readTree(line));
    } catch (IOException e) {
      log.error("Cannot read line {}", line, e);
      throw new IllegalArgumentException(e);
    }
  }
}
