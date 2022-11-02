package io.github.aj8gh.aoc.y21.day13;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Folder {
    public Set<Dot> fold(Set<Dot> dots, List<Fold> folds, int timesToFold) {
        for (int i = 0; i < timesToFold; i++) {
            Fold fold = folds.get(i);
            if (fold.getAxis().equals("x")) dots.forEach(dot -> foldOnX(dot, fold.getPoint()));
            if (fold.getAxis().equals("y")) dots.forEach(dot -> foldOnY(dot, fold.getPoint()));
        }
        return new HashSet<>(dots);
    }

    public Set<Dot> fold(Set<Dot> dots, List<Fold> folds) {
        return fold(dots, folds, folds.size());
    }

    private void foldOnX(Dot dot, int foldPoint) {
        if (dot.getX() < foldPoint) return;
        int diff = dot.getX() - foldPoint;
        dot.setX(foldPoint - diff);
    }

    private void foldOnY(Dot dot, int foldPoint) {
        if (dot.getY() < foldPoint) return;
        int diff = dot.getY() - foldPoint;
        dot.setY(foldPoint - diff);
    }
}
