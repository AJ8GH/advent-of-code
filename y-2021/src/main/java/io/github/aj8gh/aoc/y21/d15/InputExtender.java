package io.github.aj8gh.aoc.y21.d15;

public class InputExtender {

  public int[][] extend(int[][] input) {
    var newInput = new int[input.length * 5][input[0].length * 5];
    for (int i = 0; i < input.length; i++) {
      System.arraycopy(input[i], 0, newInput[i], 0, input[i].length);
    }

    for (int i = 1; i < 5; i++) {
      for (int j = 0; j < input.length; j++) {
        var newJ = j + (i * input.length);
        for (int k = 0; k < input[j].length; k++) {
          var el = input[j][k];
          newInput[newJ][k] = el + i > 9 ? el + i - 9 : el + i;
        }
      }
    }

    for (int i = 1; i < 5; i++) {
      for (int j = 0; j < newInput.length; j++) {
        for (int k = 0; k < input[0].length; k++) {
          var newK = k + (i * input.length);
          var el = newInput[j][k];
          newInput[j][newK] = el + i > 9 ? el + i - 9 : el + i;
        }
      }
    }

    return newInput;
  }
}
