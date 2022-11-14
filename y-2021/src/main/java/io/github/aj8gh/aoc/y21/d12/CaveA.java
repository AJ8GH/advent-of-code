package io.github.aj8gh.aoc.y21.d12;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
public class CaveA {
  private static final Set<CaveA> CAVES = new HashSet<>();
  private static final String END = "END";
  private static final String START = "START";

  @EqualsAndHashCode.Exclude
  private final Set<CaveA> connections = new HashSet<>();
  private final String name;

  public static CaveA create(String name) {
    for (CaveA cave : CAVES) {
      if (cave.getName().equals(name)) {
        return cave;
      }
    }
    return new CaveA(name);
  }

  public static Set<CaveA> getCaves() {
    return new HashSet<>(CAVES);
  }

  public static void clear() {
    CAVES.clear();
  }

  public void addConnection(CaveA cave) {
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

  private CaveA(String name) {
    this.name = name;
    CAVES.add(this);
  }
}
