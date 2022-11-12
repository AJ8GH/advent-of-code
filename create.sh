#!/bin/zsh

# Load environment
export "$(grep -v '^#' .env | xargs)"

year=${1}
day=${2}

new_resources_dir="/${PWD}/y-20${year}/src/main/resources/day${day}"
new_package="${PWD}/y-20${year}/src/main/java/io/github/aj8gh/aoc/y${year}/day${day}"

mkdir "${new_package}"
mkdir "${new_resources_dir}"
touch "${new_resources_dir}/example.txt"

url="https://adventofcode.com/20${year}/day/${day}"

#html=$(curl --cookie "session=${SESSION}" "${url}")
md=$(node ./scripts/script.js "${year}" "${day}" "${SESSION}")
echo "MD ----- >>>>> ${md}"
echo "${md}" > "${new_resources_dir}/README.md"

curl --cookie "session=${SESSION}" "${url}/input" > "${new_resources_dir}/input.txt"
