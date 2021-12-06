package day6;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class LanternFishSimulator {
    private static final String INPUT = "./src/main/resources/day6/input.txt";
    private static final List<LanternFish> FISH_LIST = new ArrayList<>();
    private static int count = 0;

    public static void main(String[] args) {
        deserialize();
        runSimulation(256);
        log.info("Simulation complete... counting the fish....");
        FISH_LIST.forEach(LanternFishSimulator::countFish);
        System.out.println(count);
    }

    private static void runSimulation(int days) {
        for (int i = 0; i < days; i++) {
            FISH_LIST.forEach(LanternFish::tick);
        }
    }

    private static void countFish(LanternFish fish) {
        count++;
        fish.getChildren().forEach(LanternFishSimulator::countFish);
    }

    private static void deserialize() {
        try (var reader = new BufferedReader(new FileReader(INPUT))) {
            Arrays.stream(reader.readLine().split(","))
                    .map(numStr -> new LanternFish(Integer.parseInt(numStr)))
                    .forEach(FISH_LIST::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(FISH_LIST.toString());
    }
}
