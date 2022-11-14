# Advent of Code

[![Java CI](https://github.com/AJ8GH/advent-of-code/actions/workflows/push-to-main.yaml/badge.svg)](https://github.com/AJ8GH/advent-of-code/actions/workflows/push-to-main.yaml)
[![codecov](https://codecov.io/gh/AJ8GH/advent-of-code/branch/main/graph/badge.svg?token=E2O9UWQ793)](https://codecov.io/gh/AJ8GH/advent-of-code)

[Advent of Code](https://adventofcode.com/) is an Advent calendar of small programming puzzles
for a variety of skill sets and skill levels that can be solved in any programming language.

## Build Info

- Java version: `19`
- Build tool: `Maven`
- Test framework: `JUnit`
- CI: `GH Actions`
- Test coverage: `Jacoco` & `CodeCov`

## Getting started

Build project:

```shell
mvn clean install
```

## Running tests

Run all tests:

```shell
mvn test
```

## Automation Scripts

`create.sh` script:

- Creates empty src package and resources directory containing input.txt and example.txt for given
  year and day
- Gets problem description from AOC website to create README
- Gets input from AOC website to create input.txt

Usage:

```shell
sh create.sh <year> <day>
```

E.g. for year 2022, day 1:

```shell
sh create.sh 22 1
```
