package io.github.aj8gh.aoc.y21.day12;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class Cave {
  private static final Set<Cave> CAVES = new HashSet<>();
  private static final String END = "END";
  private static final String START = "START";

  @EqualsAndHashCode.Exclude
  private final Set<Cave> connections = new HashSet<>();
  private final String name;

  public static Cave create(String name) {
    for (Cave cave : CAVES) {
      if (cave.getName().equals(name)) {
        return cave;
      }
    }
    return new Cave(name);
  }

  public static Set<Cave> getCaves() {
    return new HashSet<>(CAVES);
  }

  public static void clear() {
    CAVES.clear();
  }

  public void addConnection(Cave cave) {
    connections.add(cave);
  }

  public boolean isSmall() {
    return name.equals(name.toLowerCase());
  }

  public boolean isEnd() {
    return name.equalsIgnoreCase(END);
  }

  public boolean isStart() {
    return name.equalsIgnoreCase(START);
  }

  private Cave(String name) {
    this.name = name;
    CAVES.add(this);
  }
}
