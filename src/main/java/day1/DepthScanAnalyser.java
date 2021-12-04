package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DepthScanAnalyser {
    private static final String INPUT = "./src/main/java/day1/input.txt";

    public static void main(String[] args) {
        var analyser = new DepthScanAnalyser();
        System.out.println(analyser.runAnalysis());
    }

    private int runAnalysis() {
        List<Integer> depths = new ArrayList<>();
        int numberOfDepthIncreases = 0;
        try (Scanner scanner = new Scanner(Files.newBufferedReader(Path.of(INPUT)))) {
            while (scanner.hasNextLine()) {
                try {
                    int depth = scanner.nextInt();
                    if (depths.size() > 0 && depth > depths.get(depths.size() -1)) {
                        numberOfDepthIncreases++;
                    }
                    depths.add(depth);
                } catch (NoSuchElementException e) {
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numberOfDepthIncreases;
    }
}
