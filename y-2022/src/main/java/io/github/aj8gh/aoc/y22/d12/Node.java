package io.github.aj8gh.aoc.y22.d12;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Node implements Comparable<Node> {

  final char val;
  int row;
  int col;
  int total;

  @Override
  public int compareTo(Node node) {
    return Integer.compare(total, node.total);
  }

  @Override
  public String toString() {
    return String.valueOf(val);
  }
}
