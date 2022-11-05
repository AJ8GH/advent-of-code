package io.github.aj8gh.aoc.util;

public abstract class ReaderProvider {

  private static final Reader READER = new Reader();

  protected static Reader reader() {
    return READER;
  }
}
