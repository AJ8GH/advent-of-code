package io.github.aj8gh.aoc.y22.d7;

import java.util.List;
import java.util.regex.Pattern;

public class Day7 {

  private static final int MAX_DIR_SIZE = 100_000;
  private static final int SPACE_REQUIRED = 30_000_000;
  private static final int TOTAL_SPACE = 70_000_000;
  private static final String ROOT_DIR = "/";
  private static final String PARENT_DIR = "..";
  private static final Pattern DIR_NAME_PATTERN = Pattern.compile("\\$ cd (.+)");
  private static final Pattern FILE_SIZE_PATTERN = Pattern.compile("(^\\d+).+");
  private final DirectoryNode root = new DirectoryNode(ROOT_DIR);

  public long part1(List<String> input) {
    scanFileSystem(input);
    return getTotalSize(root);
  }

  public long part2(List<String> input) {
    scanFileSystem(input);
    var spaceToCreate = SPACE_REQUIRED - (TOTAL_SPACE - root.getRecursiveSize());
    return getDirectoryToDelete(root, spaceToCreate, TOTAL_SPACE);
  }

  private void scanFileSystem(List<String> input) {
    DirectoryNode currentDir = root;
    for (var line : input) {
      currentDir = processCommand(line, currentDir);
    }
  }

  private DirectoryNode processCommand(String line, DirectoryNode currentDir) {
    var dir = DIR_NAME_PATTERN.matcher(line);
    var size = FILE_SIZE_PATTERN.matcher(line);

    if (dir.find()) {
      currentDir = cd(dir.group(1), currentDir);
    } else if (size.find()) {
      currentDir.addFile(Long.parseLong(size.group(1)));
    }
    return currentDir;
  }

  private DirectoryNode cd(String dirName, DirectoryNode currentDir) {
    return switch (dirName) {
      case PARENT_DIR -> currentDir.parent;
      case ROOT_DIR -> root;
      default -> mkdir(dirName, currentDir);
    };
  }

  private DirectoryNode mkdir(String dirName, DirectoryNode currentDir) {
    var newNode = new DirectoryNode(dirName);
    newNode.parent = currentDir;
    currentDir.addDir(newNode);
    return newNode;
  }

  private long getTotalSize(DirectoryNode dir) {
    var dirSize = dir.getRecursiveSize();
    return (dirSize > MAX_DIR_SIZE ? 0 : dirSize)
        + dir.subDirectories.stream().map(this::getTotalSize).reduce(0L, Long::sum);
  }

  private long getDirectoryToDelete(DirectoryNode dir, long spaceToCreate, long minDir) {
    var dirSize = dir.getRecursiveSize();
    final var finalMin = dirSize >= spaceToCreate ? Math.min(minDir, dirSize) : minDir;
    return dir.subDirectories.stream()
        .map(d -> getDirectoryToDelete(d, spaceToCreate, finalMin))
        .min(Long::compareTo).orElse(finalMin);
  }
}
