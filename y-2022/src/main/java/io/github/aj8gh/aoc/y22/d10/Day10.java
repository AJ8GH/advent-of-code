package io.github.aj8gh.aoc.y22.d10;

import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day10 {

  private static final Pattern ADDX = Pattern.compile("addx (-?\\d+)");
  private static final Set<Integer> CYCLES = Set.of(20, 60, 100, 140, 180, 220);
  private final StringBuilder image = new StringBuilder();

  private int cycle;
  private int register = 1;
  private int signal;

  public int part1(List<String> input) {
    process(input, () -> signal += CYCLES.contains(++cycle) ? register * cycle : 0);
    return signal;
  }

  public String part2(List<String> input) {
    process(input, () -> {
      image.append(cycle % 40 >= register - 1 && cycle % 40 <= register + 1 ? "#" : ".");
      if ((++cycle) % 40 == 0) {
        image.append("\n");
      }
    });
    log.info("\n{}", image);
    return image.toString().trim();
  }

  private void process(List<String> input, Runnable runnable) {
    input.forEach(line -> processLine(line, runnable));
  }

  private void processLine(String line, Runnable runnable) {
    var matcher = ADDX.matcher(line);
    if (matcher.find()) {
      incrementCycle(2, runnable);
      register += Integer.parseInt(matcher.group(1));
    } else {
      incrementCycle(1, runnable);
    }
  }

  private void incrementCycle(int times, Runnable runnable) {
    for (int i = 0; i < times; i++) {
      runnable.run();
    }
  }
}
