package io.github.aj8gh.aoc.y21.day15;

import java.util.Objects;

public class Node implements Comparable<Node> {

  final int risk;
  final int i;
  final int j;
  int total;

  public Node(int risk, int i, int j) {
    this.risk = risk;
    this.i = i;
    this.j = j;
    this.total = Integer.MAX_VALUE;
  }

  @Override
  public int compareTo(Node node) {
    return Integer.compare(total, node.total);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Node node = (Node) o;
    return total == node.total;
  }

  @Override
  public int hashCode() {
    return Objects.hash(total);
  }
}
