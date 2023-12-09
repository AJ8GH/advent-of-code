package io.github.aj8gh.aoc.y23.d5;

import static java.lang.Math.min;
import static java.util.stream.LongStream.range;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Day5 {

  private static final int SOURCE_INDEX = 1;
  private static final int DESTINATION_INDEX = 0;
  private static final int LENGTH_INDEX = 2;
  private static final Pattern DIGITS = Pattern.compile("\\d+");
  private static final Pattern NAME = Pattern.compile("^[a-z\\-]+");
  private static final String SEEDS = "seeds";
  private static final Map<String, List<List<Long>>> MAP = new LinkedHashMap<>();

  public long part1(List<String> input) {
    parse(input);
    return MAP.get(SEEDS)
        .stream()
        .flatMap(Collection::stream)
        .map(this::toLocation)
        .min(Long::compareTo)
        .orElseThrow();
  }

  public long part2(List<String> input) {
    parse(input);
    return MAP.get(SEEDS)
        .stream()
        .map(this::toMinLocation)
        .min(Long::compareTo)
        .orElseThrow();
  }

  private void parse(List<String> input) {
    for (int i = 0; i < input.size(); i++) {
      var line = input.get(i);
      var name = getName(line);

      if (name.isPresent()) {
        var numList = new ArrayList<List<Long>>();
        log.info("parsing {}", name);
        line = SEEDS.equals(name.get()) ? line : input.get(++i);
        var matcher = DIGITS.matcher(line);

        while (matcher.find()) {
          numList.add(getNums(line));
          if (i >= input.size() - 1) {
            break;
          }
          line = input.get(++i);
          matcher = DIGITS.matcher(line);
        }
        MAP.put(name.get(), numList);
      }
    }
  }

  private long toLocation(long seed) {
    var mappedValue = seed;
    for (var entry : MAP.entrySet()) {
      if (SEEDS.equals(entry.getKey())) {
        continue;
      }
      for (var list : entry.getValue()) {
        var source = list.get(SOURCE_INDEX);
        var destination = list.get(DESTINATION_INDEX);
        var length = list.get(LENGTH_INDEX);

        if (mappedValue >= source && mappedValue < source + length) {
          var diff = source - destination;
          mappedValue -= diff;
          break;
        }
      }
    }
    return mappedValue;
  }

  private long toMinLocation(List<Long> seeds) {
    var minLocation = Long.MAX_VALUE;
    for (int i = 0; i < seeds.size(); i++) {
      var start = seeds.get(i);
      var range = seeds.get(++i);
      log.info("Doing seed {} range {}", start, range);
      minLocation = min(toMinLocation(start, range), minLocation);
    }
    return minLocation;
  }

  private long toMinLocation(long start, long range) {
    var end = start + range - 1;

    var minLocation = toLocation(start);
    minLocation = min(toLocation(end), minLocation);

    for (var entry : MAP.entrySet()) {
      if (SEEDS.equals(entry.getKey())) {
        continue;
      }
      for (var nums : entry.getValue()) {
        var source = nums.get(SOURCE_INDEX);
        var length = nums.get(LENGTH_INDEX);
        var finalSource = source + length - 1;

        if (start >= source && start <= finalSource) {
          minLocation = min(toLocation(source), minLocation);
          if (end > finalSource) {
            minLocation = min(toLocation(source), minLocation);
          }
        }
      }
    }
    return minLocation;
  }

  private Optional<String> getName(String line) {
    return NAME.matcher(line)
        .results()
        .map(MatchResult::group)
        .findFirst();
  }

  private List<Long> getNums(String line) {
    return DIGITS.matcher(line)
        .results()
        .map(MatchResult::group)
        .map(Long::valueOf)
        .toList();
  }
}
