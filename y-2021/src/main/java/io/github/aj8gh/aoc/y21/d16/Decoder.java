package io.github.aj8gh.aoc.y21.d16;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;

public class Decoder {
  private static final Map<String, String> HEX_TO_BINARY = Map.ofEntries(
      new AbstractMap.SimpleEntry<>("0", "0000"),
      new AbstractMap.SimpleEntry<>("1", "0001"),
      new AbstractMap.SimpleEntry<>("2", "0010"),
      new AbstractMap.SimpleEntry<>("3", "0011"),
      new AbstractMap.SimpleEntry<>("4", "0100"),
      new AbstractMap.SimpleEntry<>("5", "0101"),
      new AbstractMap.SimpleEntry<>("6", "0110"),
      new AbstractMap.SimpleEntry<>("7", "0111"),
      new AbstractMap.SimpleEntry<>("8", "1000"),
      new AbstractMap.SimpleEntry<>("9", "1001"),
      new AbstractMap.SimpleEntry<>("A", "1010"),
      new AbstractMap.SimpleEntry<>("B", "1011"),
      new AbstractMap.SimpleEntry<>("C", "1100"),
      new AbstractMap.SimpleEntry<>("D", "1101"),
      new AbstractMap.SimpleEntry<>("E", "1110"),
      new AbstractMap.SimpleEntry<>("F", "1111")
  );

  public long decode(String message) {
    var total = 0L;
    var bytes = mapToBytes(message);

    for (var b : bytes.split("")) {

    }

    return total;
  }

  private String mapToBytes(String message) {
    return String.join("", Arrays.stream(message.split(""))
        .map(HEX_TO_BINARY::get)
        .toArray(String[]::new));
  }
}
