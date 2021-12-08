package day6;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class LanternFishSimulator {
    private static final String EXAMPLE = "./src/main/resources/day6/example.txt";
    private static final String INPUT = "./src/main/resources/day6/input.txt";
    private static final String OUTPUT = "./src/main/resources/day6/output.txt";
    private static final String DELIMITER = ",";
    private static final List<LanternFish> FISH_LIST = new ArrayList<>();
    private static final List<Integer> FISH_INT_LIST = new ArrayList<>();
        private static BigInteger count = BigInteger.ZERO;

    public static void main(String[] args) {
//        deserializeToInt(EXAMPLE);
        FISH_INT_LIST.add(8);
        run256(256);
    }

    private static void runSimulation(int days) {
        log.info("Running simulation...");
        for (int i = 0; i < days; i++) {
            FISH_LIST.forEach(LanternFish::tick);
        }
    }

    private static void run256(int days) {
        log.info("Running simulation...");
        int children = 0;
        for (int i = 0; i < days; i++) {
            for (int j = 0; j < FISH_INT_LIST.size(); j++) {
                int fish = FISH_INT_LIST.get(j);
                if (fish == 0) {
                    FISH_INT_LIST.set(j, 6);
                    FISH_INT_LIST.add(8);
                } else {
                    FISH_INT_LIST.set(j, --fish);
                }
            }
        }
        System.out.println(FISH_INT_LIST.size());
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

    private static void deserializeToInt(String filePath) {
        log.info("Deserializing from file: {}", filePath);
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            for (String fish : reader.readLine().split(DELIMITER)) {
                FISH_INT_LIST.add(Integer.parseInt(fish));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void serialize(List<LanternFish> fishList, String filePath) {
        try (var writer = new BufferedWriter(new FileWriter(filePath, true))) {
            StringBuilder sb = new StringBuilder();
            for (LanternFish fish : fishList) {
                sb.append(fish.getDaysLeftInCycle()).append(DELIMITER);
            }
            writer.write(sb.toString());
            fishList.forEach(fish -> LanternFishSimulator.serialize(fish.getChildren(), filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void clearFile(String filePath) {
        try (var writer = new FileWriter(filePath, false)) {
            log.info("Cleared file: {}", filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
