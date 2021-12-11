package day9;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class RiskLevelAnalyzer {
    private static final String INPUT = "./src/main/resources/day9/input.txt";
    private static final String EXAMPLE = "./src/main/resources/day9/example.txt";

    public static void main(String[] args) {
        var riskLevelAnalyzer = new RiskLevelAnalyzer();
        var heightMap = riskLevelAnalyzer.deserialize();
        heightMap.findLowPoints();
        log.info(heightMap.getLowPoints().toString());
        int riskLevel = riskLevelAnalyzer.calculateScore(heightMap.getLowPoints());
        System.out.println(riskLevel);
    }

    private int calculateScore(List<Integer> lowPoints) {
        return lowPoints.stream().reduce(lowPoints.size(), Integer::sum);
    }

    private HeightMap deserialize() {
        List<List<Integer>> heightMatrix = new ArrayList<>();
        try (var reader = new BufferedReader(new FileReader(INPUT))) {
            String line;
            while ((line = reader.readLine()) != null) {
                heightMatrix.add(Arrays.stream(line.split(""))
                        .map(Integer::valueOf)
                        .collect(Collectors.toList()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info(new HeightMap(heightMatrix).toString());
        return new HeightMap(heightMatrix);
    }
}
