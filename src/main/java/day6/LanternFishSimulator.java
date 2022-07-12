package day6;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class LanternFishSimulator {
    private static final String EXAMPLE = "./src/main/resources/day6/example.txt";
    private static final String INPUT = "./src/main/resources/day6/input.txt";
    private static final String DELIMITER = ",";
    private static final List<LanternFish> FISH_LIST = new ArrayList<>();

    private static BigInteger count = BigInteger.ZERO;

    public static void main(String[] args) {
//        List<Integer> fishList = deserializeToInt(EXAMPLE);
//        long solution = runPart2(80, fishList);
//        log.info("Solution: {}", solution);
//        assert solution == 5934;
//
//        fishList = deserializeToInt(INPUT);
//        solution = runPart2(80, fishList);
//        log.info("Solution: {}", solution);
//        assert solution == 353079;

//        List<Integer> fishList = new ArrayList<>();
//        fishList.add(5);
//        long solution = runPart2(250, fishList);
//        log.info("Solution: {}", solution);
//        assert solution == 26984457539L;

        deserialize(EXAMPLE);
        runSimulation(250);
    }

    private static void runSimulation(int days) {
        log.info("Running simulation...");
        for (int i = 0; i < days; i++) {
            FISH_LIST.forEach(LanternFish::tick);
            log.info("Day {}:", i);
        }
    }

    private static long runPart2(int days, List<Integer> fishList) {
        for (int i = 0; i < days; i++) {
            List<Integer> newList = new ArrayList<>(fishList);
            for (int j = 0; j < fishList.size(); j++) {
                if (fishList.get(j) == 0) {
                    newList.add(8);
                    newList.set(j, 6);
                } else {
                    newList.set(j, fishList.get(j) - 1);
                }
            }
            fishList = newList;
            log.info("Day {}: {}", i, fishList.size());
        }
        return fishList.size();
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

    private static List<Integer> deserializeToInt(String filePath) {
        log.info("Deserializing from file: {}", filePath);
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            return Arrays.stream(reader.readLine().split(DELIMITER))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
