package io.github.aj8gh.aoc.y22.d12;

import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Day12 {

  private static final char START = 'S';
  private static final char END = 'E';
  private static final char A = 'a';
  private static final int MAX_DIFF = -1;

  private final Queue<Node> queue = new PriorityQueue<>();
  private final List<Node> possibleStarts = new ArrayList<>();
  private Node startNode;
  private Node endNode;
  private Node[][] nodes;
  private int minRoute = Integer.MAX_VALUE;

  public int part1(char[][] input) {
    nodes = buildGrid(input);
    findStartAndEnd(input);
    process(startNode);
    return minRoute;
  }

  public int part2(char[][] input) {
    nodes = buildGrid(input);
    findStartAndEnd(input);
    possibleStarts.forEach(node -> {
      process(node);
      reset();
    });
    return minRoute;
  }

  private void process(Node startNode) {
    queue.add(startNode);

    while (!queue.isEmpty()) {
      var node = queue.poll();
      explore(node, 0, -1);
      explore(node, -1, 0);
      explore(node, 1, 0);
      explore(node, 0, 1);
    }
    if (endNode.total != 0) {
      minRoute = Math.min(minRoute, endNode.total);
    }
  }

  private void explore(Node prev, int diffI, int diffJ) {
    int newI = prev.row + diffI;
    int newJ = prev.col + diffJ;

    if (newI >= 0 && newJ >= 0 && newI < nodes.length && newJ < nodes[newI].length) {
      var node = nodes[newI][newJ];
      if (node.total == 0 && node.val != START
          && (prev.val == START || prev.val - node.val >= MAX_DIFF)) {
        if (node.val == END && prev.val < 'y') {
          return;
        }
        node.total = prev.total + 1;
        queue.add(node);
      }
    }
  }

  private Node[][] buildGrid(char[][] input) {
    return Arrays.stream(input)
        .map(line -> CharBuffer.wrap(line).chars()
            .mapToObj(c -> new Node((char) c))
            .toArray(Node[]::new))
        .toArray(Node[][]::new);
  }

  private void findStartAndEnd(char[][] input) {
    for (int i = 0; i < input.length; i++) {
      for (int j = 0; j < input[i].length; j++) {
        nodes[i][j].row = i;
        nodes[i][j].col = j;
        if (input[i][j] == START) {
          startNode = nodes[i][j];
        } else if (input[i][j] == END) {
          endNode = nodes[i][j];
        } else if (input[i][j] == A) {
          possibleStarts.add(nodes[i][j]);
        }
      }
    }
  }

  private void reset() {
    for (var line : nodes) {
      for (var node : line) {
        node.total = 0;
      }
    }
  }
}
