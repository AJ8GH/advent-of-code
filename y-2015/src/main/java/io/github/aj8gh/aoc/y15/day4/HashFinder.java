package io.github.aj8gh.aoc.y15.day4;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class HashFinder {
  private static final String ALGORITHM = "MD5";

  public int find(String key, int numZeroes) throws NoSuchAlgorithmException {
    var prefix = "0".repeat(numZeroes);
    var md = MessageDigest.getInstance(ALGORITHM);
    var hash = "";

    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      var bytes = (key + i).getBytes();
      var digest = md.digest(bytes);
      hash = HexFormat.of().formatHex(digest);
      if (hash.startsWith(prefix)) {
        return i;
      }
    }
    return -1;
  }
}
