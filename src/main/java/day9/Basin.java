package day9;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Basin {
    private final Set<Point> points = new HashSet<>();

    public boolean add(Point point) {
        return points.add(point);
    }

    public Integer size() {
        return points.size();
    }
}
