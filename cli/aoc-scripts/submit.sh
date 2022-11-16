#!/bin/zsh

WORK_DIR=$(dirname "${0}")
source "${WORK_DIR}/.env"

answer=${1}
level=${2}
year=${3}
day=${4}
session="${SESSION}"
aoc_url="${AOC_URL}"
project_dir="${PROJECT_DIR}"

if [[ -z ${level} ]]; then
  level=${LEVEL}
fi

if [[ -z ${day} ]]; then
  day=${DAY}
fi

if [[ -z ${year} ]]; then
  year=${YEAR}
fi

echo "Submitting answer for ${year} day ${day} level ${level} ..."
url="${aoc_url}/20${year}/day/${day}"
response=$(curl --cookie "session=${session}" "${url}/answer" -X POST -d "level=${level}&answer=${answer}")

result=$(python "${WORK_DIR}/env_script.py" "${response}" "submit" 1 0 0 "${project_dir}/aoc-scripts")
if [[ "${result}" == "Congratulations, that's the correct answer!" ]]; then
  mv "${WORK_DIR}/.env1" "${WORK_DIR}/.env"
fi
echo "${result}"

source "${WORK_DIR}/.env"
echo "Next submission will be for ${YEAR} day ${DAY} level ${LEVEL}"
