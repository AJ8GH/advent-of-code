#!/bin/zsh

work_dir=$(dirname "${0}")
year=${1}
day=${2}
src_path=${3}
res_path=${4}

session="${AOC_SESSION}"
aoc_url="${AOC_URL}"
input_file="${AOC_INPUT_FILE}"
example_file="${AOC_EXAMPLE_FILE}"

_create_directories() {
  echo "Creating directories ..."
  mkdir -p "${src_path}"
  mkdir -p "${res_path}"
}

_create_example() {
  echo "Creating ${example_file} ..."
  touch "${res_path}${example_file}"
}

_create_readme() {
  echo 'Parsing description into README.md ...'
  md=$(node "${work_dir}/markdown.js" "${year}" "${day}" "${session}")
  echo "${md}" >"${res_path}README.md"
  python "${work_dir}/readme.py" "${res_path}/README.md"
}

_get_input() {
  echo "Getting input from AoC website and creating ${input_file} ..."
  url="${aoc_url}/20${year}/day/${day}"
  curl --cookie "session=${session}" "${url}/input" >"${res_path}${input_file}"
}

_create_directories
_create_example
_create_readme
_get_input
