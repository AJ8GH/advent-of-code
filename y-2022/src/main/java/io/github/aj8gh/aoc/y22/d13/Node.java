package io.github.aj8gh.aoc.y22.d13;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Node implements Comparable<Node> {

  private JsonNode val;

  @Override
  public int compareTo(@NonNull Node other) {
    if (isInt() && other.isInt()) {
      return Integer.compare(intValue(), other.intValue());
    } else if (!isInt() && !other.isInt()) {
      for (int i = 0; i < Math.min(size(), other.size()); i++) {
        var comparison = new Node(get(i)).compareTo(new Node(other.get(i)));
        if (comparison != 0) {
          return comparison;
        }
      }
      return size() - other.size();
    }

    return toArrayNode().compareTo(other.toArrayNode());
  }

  public boolean isInt() {
    return val.isInt();
  }

  public int intValue() {
    return val.intValue();
  }

  public int size() {
    return val.size();
  }

  public JsonNode get(int i) {
    return val.get(i);
  }

  private Node toArrayNode() {
    if (!val.isArray()) {
      this.val = JsonNodeFactory.instance.arrayNode().add(val);
    }
    return this;
  }

  @Override
  public String toString() {
    return val.toString();
  }
}
