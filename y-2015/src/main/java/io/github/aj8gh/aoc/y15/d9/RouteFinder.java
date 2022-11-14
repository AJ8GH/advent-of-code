package io.github.aj8gh.aoc.y15.d9;

import static java.util.Comparator.comparingInt;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class RouteFinder {

  private final Map<String, Node> nodes = new HashMap<>();
  private final Queue<Map.Entry<Node, Integer>> queue =
      new PriorityQueue<>(comparingInt(e -> e.getKey().getDistance()));
  private String first;
  private String last;

  public int find(List<String> distances) {
    buildNodes(distances);
    queue.add(new AbstractMap.SimpleEntry<>(nodes.get(first), 0));
    while (!queue.isEmpty()) {
      var entry = queue.poll();
      for (var node : entry.getKey().getNodes()) {
        process(node, entry);
      }
    }
    return nodes.get(last).getDistance();
  }

  private void buildNodes(List<String> distances) {
    var splits = distances.stream()
        .map(line -> line.split(" "))
        .toList();

    first = splits.get(0)[0];
    last = splits.get(splits.size() - 1)[2];

    for (String[] split : splits) {
      nodes.computeIfAbsent(split[0], Node::new)
          .addNode(nodes.computeIfAbsent(split[2], Node::new), Integer.parseInt(split[4]));
    }
    nodes.get(first).setDistance(0);
  }

  private void process(Map.Entry<Node, Integer> current, Map.Entry<Node, Integer> previous) {
    var currentNode = current.getKey();
    if (currentNode.getNodesVisited() == 0
        || currentNode.getNodesVisited() < previous.getKey().getNodesVisited()
        || !previous.getKey().isVisited()) {
      currentNode.setDistance(previous.getKey().getDistance() + current.getValue());
      currentNode.setNodesVisited(previous.getKey().getNodesVisited() + 1);
    }
    previous.getKey().setVisited(true);
    queue.addAll(currentNode.getNodes());
  }
}
