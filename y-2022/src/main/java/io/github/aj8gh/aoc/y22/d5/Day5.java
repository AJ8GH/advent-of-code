package io.github.aj8gh.aoc.y22.d5;

import java.util.ArrayDeque;
import java.util.List;
import java.util.function.BiConsumer;

public class Day5 {

  private static final Parser PARSER = new Parser();

  public String part1(List<String> input) {
    return process(input, this::moveSingle);
  }

  public String part2(List<String> input) {
    return process(input, this::moveMultiple);
  }

  private String process(List<String> input,
                         BiConsumer<List<Integer>, List<ArrayDeque<Character>>> consumer) {
    var stacks = PARSER.buildStacks(input);
    var instructions = PARSER.getInstructions(input);
    instructions.forEach(instruction -> consumer.accept(instruction, stacks));
    return String.join("", stacks.stream().map(ArrayDeque::remove).map(String::valueOf).toList());
  }

  private void moveSingle(List<Integer> instruction, List<ArrayDeque<Character>> stacks) {
    for (int i = 0; i < instruction.get(0); i++) {
      Character toAdd = stacks.get(instruction.get(1) - 1).remove();
      stacks.get(instruction.get(2) - 1).push(toAdd);
    }
  }

  private void moveMultiple(List<Integer> instruction, List<ArrayDeque<Character>> stacks) {
    var toAdd = new ArrayDeque<Character>();
    for (int i = 0; i < instruction.get(0); i++) {
      toAdd.add(stacks.get(instruction.get(1) - 1).remove());
    }
    while (!toAdd.isEmpty()) {
      stacks.get(instruction.get(2) - 1).push(toAdd.removeLast());
    }
  }
}
