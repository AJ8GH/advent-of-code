package io.github.aj8gh.aoc.y21.day9;

import lombok.Data;

@Data
public class Point {
    private final int height;
    private int x;
    private int y;

    public Point setX(int x) {
        this.x = x;
        return this;
    }

    public Point setY(int y) {
        this.y = y;
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(height);
    }
}
