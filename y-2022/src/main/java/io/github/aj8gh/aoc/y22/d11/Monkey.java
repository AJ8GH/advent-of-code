package io.github.aj8gh.aoc.y22.d11;

import java.util.Queue;
import java.util.function.ToLongBiFunction;

public class Monkey {

  private final ToLongBiFunction<Long, Long> func;
  private final long ifTrue;
  private final long ifFalse;

  private final long testNumber;
  private final Queue<Long> items;
  private final long operand;
  private long operations;
  private long cycle;

  public Monkey(Queue<Long> items,
                ToLongBiFunction<Long, Long> func,
                long operand,
                long test,
                long ifTrue,
                long ifFalse) {
    this.items = items;
    this.func = func;
    this.operand = operand;
    this.testNumber = test;
    this.ifTrue = ifTrue;
    this.ifFalse = ifFalse;
  }

  public Long[] test(long worry, int divisor) {
    operations++;
    var result = func.applyAsLong(worry, operand) / divisor;
    result %= cycle;
    var next = result % testNumber == 0 ? ifTrue : ifFalse;
    return new Long[] {next, result};
  }

  public void add(long item) {
    items.add(item);
  }

  public Queue<Long> getItems() {
    return items;
  }

  public long getOperations() {
    return operations;
  }

  public long getTestNumber() {
    return testNumber;
  }

  public void setCycle(long cycle) {
    this.cycle = cycle;
  }
}
