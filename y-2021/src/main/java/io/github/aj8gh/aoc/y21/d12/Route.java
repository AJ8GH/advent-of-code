package io.github.aj8gh.aoc.y21.d12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Data;

@Data
public class Route {
  private final List<CaveA> caves;
  private boolean doubleVisit = false;

  public Route(List<CaveA> caves, boolean doubleVisit) {
    this.caves = caves;
    this.doubleVisit = doubleVisit;
  }

  public Route() {
    this.caves = new ArrayList<>();
  }

  public CaveA getFirst() {
    return caves.get(0);
  }

  public CaveA getLast() {
    return caves.get(caves.size() - 1);
  }

  public boolean add(CaveA cave) {
    caves.add(cave);
    return isValid();
  }

  public boolean isValid() {
    Map<CaveA, Integer> tally = new HashMap<>();
    caves.stream().filter(CaveA::isSmall)
        .forEach(c -> tally.put(c, tally.getOrDefault(c, 0) + 1));
    return !doubleVisit ? tally.values().stream().noneMatch(n -> n > 1)
        : tally.values().stream().filter(n -> n > 1).count() <= 1
        && tally.values().stream().noneMatch(n -> n > 2);
  }

  public boolean isComplete() {
    return getLast().isEnd();
  }
}
