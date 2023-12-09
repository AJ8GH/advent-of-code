package io.github.aj8gh.aoc.util;

import static lombok.AccessLevel.PROTECTED;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = PROTECTED)
public abstract class InputProvider {

  private static final Reader READER = new Reader();

  protected static final String INPUT_PROVIDER = "inputProvider";
  protected static final String INPUT_PROVIDER_PART_1 = "inputProviderPart1";
  protected static final String INPUT_PROVIDER_PART_2 = "inputProviderPart2";

  protected static final int DAY_1 = 1;
  protected static final int DAY_2 = 2;
  protected static final int DAY_3 = 3;
  protected static final int DAY_4 = 4;
  protected static final int DAY_5 = 5;
  protected static final int DAY_6 = 6;
  protected static final int DAY_7 = 7;
  protected static final int DAY_8 = 8;
  protected static final int DAY_9 = 9;
  protected static final int DAY_10 = 10;
  protected static final int DAY_11 = 11;
  protected static final int DAY_12 = 12;
  protected static final int DAY_13 = 13;
  protected static final int DAY_14 = 14;
  protected static final int DAY_15 = 15;
  protected static final int DAY_16 = 16;
  protected static final int DAY_17 = 17;
  protected static final int DAY_18 = 18;
  protected static final int DAY_19 = 19;
  protected static final int DAY_20 = 20;
  protected static final int DAY_21 = 21;
  protected static final int DAY_22 = 22;
  protected static final int DAY_23 = 23;
  protected static final int DAY_24 = 24;
  protected static final int DAY_25 = 25;

  protected static Reader reader() {
    return READER;
  }
}
