package io.github.aj8gh.aoc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reader {

  private static final Logger LOGGER = LoggerFactory.getLogger(Reader.class);
  private static final String INPUT = "d%s/input.txt";
  private static final String EXAMPLE = "d%s/example.txt";
  private static final String EXAMPLE_2 = "d%s/example2.txt";
  private static final String EXAMPLE_3 = "d%s/example3.txt";

  public Input getInput(int day) {
    return new Input(getStream(INPUT, day));
  }

  public Input getExample(int day) {
    return new Input(getStream(EXAMPLE, day));
  }

  public Input get(int day, String fileName) {
    return new Input(getStream(fileName, day));
  }

  public Input getExample2(int day) {
    return new Input(getStream(EXAMPLE_2, day));
  }

  public Input getExample3(int day) {
    return new Input(getStream(EXAMPLE_3, day));
  }

  private Stream<String> getStream(String file, int day) {
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
