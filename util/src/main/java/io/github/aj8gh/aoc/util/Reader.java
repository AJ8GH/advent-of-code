package io.github.aj8gh.aoc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reader {

  private static final Logger LOGGER = LoggerFactory.getLogger(Reader.class);
  private static final String INPUT = "day%s/input.txt";
  private static final String EXAMPLE = "day%s/example.txt";
  private static final String EXAMPLE_2 = "day%s/example2.txt";

  private Stream<String> result = Stream.empty();

  public Reader getInput(int day) {
    this.result = get(INPUT, day);
    return this;
  }

  public Reader getExample(int day) {
    this.result = get(EXAMPLE, day);
    return this;
  }

  public Reader getExample2(int day) {
    this.result = get(EXAMPLE_2, day);
    return this;
  }

  public String asString() {
    return String.join("", result.toList());
  }

  public List<String> asStringList() {
    return result.toList();
  }

  public List<Integer> asIntList() {
    return result.map(Integer::parseInt).toList();
  }

  private Stream<String> get(String file, int day) {
    try (var reader = getBufferedReader(String.format(file, day))) {
      return reader.lines().toList().stream();
    } catch (IOException e) {
      LOGGER.error("Exception reading {}", file, e);
      return Stream.empty();
    }
  }

  private BufferedReader getBufferedReader(String file) throws IOException {
    var in = this.getClass().getClassLoader().getResourceAsStream(file);
    if (in == null) {
      throw new IOException("Exception reading " + file);
    }
    return new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
  }
}
