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
        runSimulation(80);
        FISH_LIST.forEach(LanternFishSimulator::countFish);
        System.out.println(count);
    }

    private static void deserialize() {
        try (var reader = new BufferedReader(new FileReader(INPUT))) {
            List<String> data = Arrays.asList(reader.readLine().split(","));
            data.stream().map(numStr -> {
                int cycleDays = Integer.parseInt(numStr);
                return new LanternFish(cycleDays);
            }).forEach(FISH_LIST::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(FISH_LIST.toString());
    }

    private static void runSimulation(int days) {
        for (int i = 0; i < days; i++) {
            FISH_LIST.forEach(LanternFish::tick);
        }
    }

    private static void countFish(LanternFish fish) {
        count++;
        if (!fish.getChildren().isEmpty()) {
            for (LanternFish child : fish.getChildren()) {
                countFish(child);
            }
        }
    }
}
