package day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {

  private static final String EXAMPLE = "./src/main/resources/day6/example.txt";
  private static final String INPUT = "./src/main/resources/day6/input.txt";
  private static final String DELIMITER = ",";

  public static void main(String[] args) throws IOException {
    var starterFish = deserialize(INPUT);
    var fishSimulator = new FishSimulator(starterFish);
    long count = fishSimulator.runSimulation(256);
    System.out.println(count);
    assert (count == 1605400130036L);
  }

  private static List<Integer> deserialize(String filePath) throws IOException {
    try (var reader = new BufferedReader(new FileReader(filePath))) {
      return Arrays.stream(reader.readLine().split(DELIMITER))
          .map(Integer::valueOf)
          .toList();
    }
  }
}
