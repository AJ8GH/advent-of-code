package io.github.aj8gh.aoc.y21.day11;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    private static final String EXAMPLE = "./src/main/resources/io.github.aj8gh.aoc.y21.day11/example.txt";
    private static final String INPUT = "./src/main/resources/io.github.aj8gh.aoc.y21.day11/input.txt";
    private static int firstSimultaneousFlash;

    public static void main(String[] args) {
        // part 1
        OctopusEnergyTracker tracker = deserialize(EXAMPLE);
        runSimulation(100, tracker);
        log.info("Part 1 - Example: {}", tracker.getFlashes());
        assert tracker.getFlashes() == 1656;

        tracker = deserialize(INPUT);
        runSimulation(100, tracker);
        log.info("Part 1 - Solution: {}", tracker.getFlashes());
        assert tracker.getFlashes() == 1732;

        // part 2
        tracker = deserialize(EXAMPLE);
        runSimulation(500, tracker);
        log.info("Part 2 - Example: {}", firstSimultaneousFlash);
        assert firstSimultaneousFlash == 195;

        tracker = deserialize(INPUT);
        runSimulation(500, tracker);
        log.info("Part 1 - Solution: {}", firstSimultaneousFlash);
        assert firstSimultaneousFlash == 290;
    }

    private static void runSimulation(int steps, OctopusEnergyTracker tracker) {
        for (int i = 0; i < steps; i++) {
            tracker.tickAll();
            if (tracker.isSimultaneousFlash()) {
                firstSimultaneousFlash = i + 1;
                break;
            };
        }
    }

    private static OctopusEnergyTracker deserialize(String filePath) {
        List<List<DumboOctopus>> octopuses = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                octopuses.add(Arrays.stream(line.split(""))
                        .map(n -> new DumboOctopus(Integer.parseInt(n)))
                        .collect(Collectors.toList()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new OctopusEnergyTracker(octopuses);
    }
}
