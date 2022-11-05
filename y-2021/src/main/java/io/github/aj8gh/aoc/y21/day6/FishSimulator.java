package io.github.aj8gh.aoc.y21.day6;

import java.util.Arrays;
import java.util.List;

public class FishSimulator {

  private static final int NUM_STATES = 9;
  private static final int NEW_BORN_STATE = 8;
  private static final int POST_BREED_STATE = 6;
  private static final int PRE_BREED_STATE = 0;

  private final List<Integer> starterFish;

  public FishSimulator(List<Integer> starterFish) {
    this.starterFish = starterFish;
  }

  public long runSimulation(int days) {
    System.out.println("RUNNING");
    var fish = new long[NUM_STATES];

    starterFish.forEach(f -> ++fish[f]);

    for (int i = 0; i < days; i++) {
      var breedingFish = fish[PRE_BREED_STATE];
      for (int j = 0; j < fish.length - 1; j++) {
        fish[j] = fish[j + 1];
      }
      fish[NEW_BORN_STATE] = breedingFish;
      fish[POST_BREED_STATE] = fish[POST_BREED_STATE] + breedingFish;
    }
    return Arrays.stream(fish)
        .reduce(Long::sum)
        .getAsLong();
  }
}
