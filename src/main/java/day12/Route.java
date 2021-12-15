package day12;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Route {
    private final List<Cave> caves;
    private boolean doubleVisit = false;

    public Route(List<Cave> caves, boolean doubleVisit) {
        this.caves = caves;
        this.doubleVisit = doubleVisit;
    }

    public Route() {
        this.caves = new ArrayList<>();
    }

    public Cave getFirst() {
        return caves.get(0);
    }

    public Cave getLast() {
        return caves.get(caves.size() - 1);
    }

    public boolean add(Cave cave) {
        caves.add(cave);
        return isValid();
    }

    public boolean isValid() {
        Map<Cave, Integer> tally = new HashMap<>();
        caves.stream().filter(Cave::isSmall)
                .forEach(c -> tally.put(c, tally.getOrDefault(c, 0) + 1));
        return !doubleVisit ?
                tally.values().stream().noneMatch(n -> n > 1) :
                tally.values().stream().filter(n -> n > 1).count() <= 1 &&
                        tally.values().stream().noneMatch(n -> n > 2);
    }

    public boolean isComplete() {
        return getLast().isEnd();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        caves.forEach(cave -> sb.append(cave.getName()).append("--"));
        return sb.substring(0, sb.length() - 2);
    }
}
