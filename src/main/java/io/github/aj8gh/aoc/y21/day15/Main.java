package io.github.aj8gh.aoc.y21.day15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
  private static final String INPUT = "./src/main/resources/io.github.aj8gh.aoc.y21.day15/input.txt";
  private static final String EXAMPLE = "./src/main/resources/io.github.aj8gh.aoc.y21.day15/example.txt";

  public static void main(String[] args) {

    // example
    RouteFinder routeFinder = new RouteFinder(deserialize(EXAMPLE));
    var result = routeFinder.find();
    log.info("Example 1: {}", result);
    assert result == 40;

    // solution
    routeFinder = new RouteFinder(deserialize(INPUT));
    result = routeFinder.find();
    assert result == 583;
    log.info("Solution 1: {}", result);

    // extended
    var extender = new InputExtender();
    routeFinder = new RouteFinder(extender.extend(deserialize(EXAMPLE)));
    result = routeFinder.find();
    log.info("Example 2: {}", result);
    assert result == 315;

    var extendedInput = extender.extend(deserialize(INPUT));
    routeFinder = new RouteFinder(extendedInput);
    result = routeFinder.find();
    log.info("Solution 2: {}", result);
    assert result == 2927;
  }

  private static int[][] deserialize(String filePath) {
    try (var reader = new BufferedReader(new FileReader(filePath))) {
      List<int[]> rows = new ArrayList<>();
      String line;
      while ((line = reader.readLine()) != null) {
        var row = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
        rows.add(row);
      }
      return rows.toArray(new int[0][]);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return new int[][] {};
  }
}
