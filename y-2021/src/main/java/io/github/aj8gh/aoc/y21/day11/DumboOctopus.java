package io.github.aj8gh.aoc.y21.day11;

import lombok.Data;

@Data
public class DumboOctopus {
    private int energy;
    private int x;
    private int y;

    public DumboOctopus(int energy) {
        this.energy = energy;
    }

    public boolean tick() {
        energy++;
        return (energy == 10);
    }

    public void reset() {
        if (energy > 9) this.energy = 0;
    }

    @Override
    public String toString() {
        return String.valueOf(energy);
    }
}
