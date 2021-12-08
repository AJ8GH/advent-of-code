package day7;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class CrabAligner {
    private static final String INPUT = "./src/main/resources/day7/input.csv";
    private static final String EXAMPLE = "./src/main/resources/day7/example.csv";

    private final List<Integer> crabPositions = new ArrayList<>();

    public static void main(String[] args) {
        var crabAligner = new CrabAligner();
        crabAligner.deserializeInput(INPUT);

        // part 1
        var distances = crabAligner.getDistances();
        int solution1 = distances.get(0);
        System.out.println(solution1);

        // part 2
        var fuelCosts = crabAligner.getFuelCosts();
        log.info(fuelCosts.toString());
        long solution2 = fuelCosts.get(0);
        System.out.println(solution2);
    }

    private List<Integer> getDistances() {
        List<Integer> distances = new ArrayList<>();
        crabPositions.sort(Integer::compareTo);
        for (int i = 0; i < crabPositions.get(crabPositions.size() - 1); i++) {
            int distance = 0;
            for (Integer crab : crabPositions) {
                distance += Math.abs(i - crab);
            }
            distances.add(distance);
        }
        distances.sort(Integer::compareTo);
        return distances;
    }

    private List<Integer> getFuelCosts() {
        List<Integer> fuelCosts = new ArrayList<>();
        for (int i = 0; i < crabPositions.get(crabPositions.size() - 1); i++) {
            int fuelCost = 0;
            for (Integer crab : crabPositions) {
                int distance = Math.abs(i - crab);
                for (int j= 1; j <= distance; j++) {
                    fuelCost += j;
                }
            }
            fuelCosts.add(fuelCost);
        }
        fuelCosts.sort(Integer::compareTo);
        return fuelCosts;
    }

    private void deserializeInput(String filePath) {
        try (var reader = new BufferedReader(new FileReader(filePath))) {
            Arrays.stream(reader.readLine().split(","))
                    .forEach(crab -> crabPositions.add(Integer.parseInt(crab)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        crabPositions.sort(Integer::compareTo);
        log.info(crabPositions.toString());
    }
}
