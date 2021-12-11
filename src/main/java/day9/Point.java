package day9;

import lombok.Data;

import java.util.Objects;

@Data
public class Point {
    private final int height;
    private int x;
    private int y;

    @Override
    public String toString() {
        return String.valueOf(height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return height == point.height && x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, x, y);
    }
}
