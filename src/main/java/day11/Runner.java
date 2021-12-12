package day11;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class Runner {
    private static final String EXAMPLE = "./src/main/resources/day11/example.txt";
    private static final String INPUT = "./src/main/resources/day11/input.txt";

    public static void main(String[] args) {
        // part 1
        OctopusEnergyTracker tracker = deserialize(EXAMPLE);
        runSimulation(100, tracker);
        log.info("Part 1 - Example: {}", tracker.getFlashes());
        assert tracker.getFlashes() == 1656;

        tracker = deserialize(INPUT);
        runSimulation(100, tracker);
        log.info("Part 1 - Solution: {}", tracker.getFlashes());
//        assert tracker.getFlashes() == 1656;

    }

    private static void runSimulation(int steps, OctopusEnergyTracker tracker) {
        for (int i = 0; i < steps; i++) {
            tracker.tick();
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
