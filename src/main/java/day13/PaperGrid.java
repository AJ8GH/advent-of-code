package day13;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
public class PaperGrid {
    private final List<List<Object>> grid = new ArrayList<>();

    public List<List<Object>> mapDots(Set<Dot> dots) {
        grid.clear();
        createEmptyGrid(getMaxX(dots), getMaxY(dots));
        for (Dot dot : dots) {
            grid.get(dot.getY()).set(dot.getX(), dot);
        }
        return grid;
    }

    private void createEmptyGrid(int maxX, int maxY) {
        for (int i = 0; i < maxY + 1; i++) {
            List<Object> row = new ArrayList<>(maxX);
            for (int j = 0; j < maxX + 1; j++) row.add(".");
            grid.add(row);
        }
    }

    private int getMaxX(Set<Dot> dots) {
        return dots.stream().map(Dot::getX).sorted()
                .collect(Collectors.toList()).get(dots.size() - 1);
    }

    private int getMaxY(Set<Dot> dots) {
        return dots.stream().map(Dot::getX).sorted()
                .collect(Collectors.toList()).get(dots.size() - 1);
    }
}
