package io.github.aj8gh.aoc.y15.day4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HashFinderTest {

  @ParameterizedTest
  @MethodSource(value = "inputProviderPart1")
  void find(String input, int numZeroes, int expected) throws NoSuchAlgorithmException {
    var hashFinder = new HashFinder();
    assertEquals(expected, hashFinder.find(input, numZeroes));
  }

  private static Stream<Arguments> inputProviderPart1() {
    return Stream.of(
        Arguments.of("abcdef", 5, 609043),
        Arguments.of("pqrstuv", 5, 1048970),
        Arguments.of("yzbqklnj", 5, 282749),
        Arguments.of("yzbqklnj", 6, 9962624)
    );
  }
}
