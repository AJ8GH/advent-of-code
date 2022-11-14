package io.github.aj8gh.aoc.y21.day13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Folder {
  private final List<Fold> folds = new ArrayList<>();
  private final Set<Dot> dots = new HashSet<>();

  public int getNumDots(List<String> input) {
    getFoldsAndDots(input);
    return fold(dots, folds, 1).size();
  }

  public String getCode(List<String> input) {
    getFoldsAndDots(input);
    fold(dots, folds);
    var result = new PaperGrid().mapDots(dots);
    result.stream()
        .map(List::toString)
        .forEach(log::info);
    return result.toString();
  }

  public Set<Dot> fold(Set<Dot> dots, List<Fold> folds, int timesToFold) {
    for (int i = 0; i < timesToFold; i++) {
      Fold fold = folds.get(i);
      if (fold.getAxis().equals("x")) {
        dots.forEach(dot -> foldOnX(dot, fold.getPoint()));
      }
      if (fold.getAxis().equals("y")) {
        dots.forEach(dot -> foldOnY(dot, fold.getPoint()));
      }
    }
    return new HashSet<>(dots);
  }

  public Set<Dot> fold(Set<Dot> dots, List<Fold> folds) {
    return fold(dots, folds, folds.size());
  }

  private void foldOnX(Dot dot, int foldPoint) {
    if (dot.getPointX() < foldPoint) {
      return;
    }
    int diff = dot.getPointX() - foldPoint;
    dot.setPointX(foldPoint - diff);
  }

  private void foldOnY(Dot dot, int foldPoint) {
    if (dot.getPointY() < foldPoint) {
      return;
    }
    int diff = dot.getPointY() - foldPoint;
    dot.setPointY(foldPoint - diff);
  }

  private void getFoldsAndDots(List<String> input) {
    for (var line : input) {
      if (line.isEmpty()) {
        continue;
      }
      if (!line.contains("=")) {
        deserializeFold(line);
      } else {
        deserializeDot(line);
      }
    }
  }

  private void deserializeFold(String line) {
    String[] dotPoints = line.split(",");
    dots.add(new Dot(Integer.parseInt(dotPoints[0]), Integer.parseInt(dotPoints[1])));
  }

  private void deserializeDot(String line) {
    String[] fold = line.split("=");
    String axis = fold[0].substring(fold[0].length() - 1);
    Integer point = Integer.valueOf(fold[1]);
    folds.add(new Fold(axis, point));
  }
}
