package day6;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class LanternFishSimulator {
    private static final String EXAMPLE = "./src/main/resources/day6/example.txt";
    private static final String INPUT = "./src/main/resources/day6/input.txt";
    private static final String DELIMITER = ",";
    private static final List<LanternFish> FISH_LIST = new ArrayList<>();

    private static BigInteger count = BigInteger.ZERO;

    public static void main(String[] args) {
        deserialize(EXAMPLE);
    }

    private static void runSimulation(int days) {
        log.info("Running simulation...");
        for (int i = 0; i < days; i++) {
            FISH_LIST.forEach(LanternFish::tick);
        }
    }

    private static void countFish(LanternFish fish) {
        count = count.add(BigInteger.ONE);
        fish.getChildren().forEach(LanternFishSimulator::countFish);
    }

    private static void deserialize(String filePath) {
        log.info("Deserializing from file: {}", filePath);
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            Arrays.stream(reader.readLine().split(DELIMITER))
                    .map(numStr -> new LanternFish(Integer.parseInt(numStr)))
                    .forEach(FISH_LIST::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
