package io.github.aj8gh.aoc.y22.d7;

import java.util.HashSet;
import java.util.Set;

public class DirectoryNode {

  final Set<DirectoryNode> directories = new HashSet<>();
  final String name;
  DirectoryNode parent;
  long sizeOfFiles;

  public DirectoryNode(String name) {
    this.name = name;
  }

  public void addDir(DirectoryNode dir) {
    directories.add(dir);
  }

  public void addFile(long size) {
    sizeOfFiles += size;
  }

  public long getRecursiveSize() {
    return sizeOfFiles + directories.stream()
        .map(DirectoryNode::getRecursiveSize)
        .reduce(0L, Long::sum);
  }
}
