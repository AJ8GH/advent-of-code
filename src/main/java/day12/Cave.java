package day12;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.HashSet;
import java.util.Set;

@Data
public class Cave {
    private static final Set<Cave> CAVES = new HashSet<>();

    @EqualsAndHashCode.Exclude
    private final Set<Cave> connections = new HashSet<>();
    private final String name;

    public static Cave create(String name) {
        for (Cave cave : CAVES) if (cave.getName().equals(name)) return cave;
        return new Cave(name);
    }

    public static Set<Cave> getCaves() {
        return new HashSet<>(CAVES);
    }

    public static void clear() {
        CAVES.clear();
    }

    public boolean addConnection(Cave cave) {
        return connections.add(cave);
    }

    public boolean isSmall() {
        return name.equals(name.toLowerCase());
    }

    public boolean isEnd() {
        return name.equalsIgnoreCase("end");
    }

    public boolean isStart() {
        return name.equalsIgnoreCase("start");
    }

    private Cave(String name) {
        this.name = name;
        CAVES.add(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name).append(" ---> ");
        connections.forEach(cave -> sb.append(cave.getName()).append(", "));
        return sb.toString();
    }
}
