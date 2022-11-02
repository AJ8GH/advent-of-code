package io.github.aj8gh.aoc.y21.day14;

public class Node {

  private String value;
  private Node next;
  private Node previous;

  public Node(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  public Node getNext() {
    return next;
  }

  public Node getPrevious() {
    return previous;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public void setPrevious(Node previous) {
    this.previous = previous;
  }

  @Override
  public String toString() {
    return value + "," + next;
  }
}
