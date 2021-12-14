package day12;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class Route {
    private final List<Cave> caves;

    public Route(List<Cave> caves) {
        this.caves = caves;
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
        if (!getFirst().isStart()) return false;
        Map<Cave, Integer> smallCaveMap = new HashMap<>();
        caves.forEach(cave -> {
            if (cave.isSmall()) {
                int count = smallCaveMap.getOrDefault(cave, 0);
                smallCaveMap.put(cave, ++count);
            }
        });
        return smallCaveMap.values().stream().noneMatch(n -> n > 1);
    }

    public boolean isComplete() {
        return getLast().isEnd();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        caves.forEach(cave -> sb.append(cave.getName()).append("--"));
        return sb.toString();
    }
}
