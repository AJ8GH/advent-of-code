#!/bin/zsh

WORK_DIR=$(dirname "${0}")
source "${WORK_DIR}/.env"

year=${1}
day=${2}
session="${SESSION}"
aoc_url="${AOC_URL}"
project_dir="${PROJECT_DIR}"
source_dir="${SOURCE_DIR}"
resources_dir="${RESOURCES_DIR}"
resources_year_subdir="${RESOURCES_YEAR_SUBDIR}"
module="${MODULE_PREFIX}${YEAR}/"
year_prefix="${YEAR_PREFIX}"
day_prefix="${DAY_PREFIX}"
input_file="${INPUT_FILE}"
example_file="${EXAMPLE_FILE}"

if [[ -z ${day} ]]; then
  day=${DAY}
fi

if [[ -z ${year} ]]; then
  year=${YEAR}
fi

year_package="${year_prefix}${year}/"
if [[ -z ${year_prefix} ]]; then
  year_package="/"
fi

day_package="${day_prefix}${day}/"
if [[ -z ${day_prefix} ]]; then
  day_package="d${day}/"
fi

new_resources_dir="${project_dir}${module}${resources_dir}${resources_year_subdir}${day_package}"
new_package="${project_dir}${module}${source_dir}${year_package}${day_package}"

echo "Creating package ${year_package}${day_package} ..."
mkdir "${new_package}"

echo "Creating 20${year} ${day_package} resources directory ..."
mkdir "${new_resources_dir}"

echo "Creating ${example_file} ..."
touch "${new_resources_dir}${example_file}"

echo 'Getting problem description from AoC website and converting to Markdown ...'
md=$(node "${WORK_DIR}/script.js" "${year}" "${day}" "${session}")

echo 'Creating README.md ...'
echo "${md}" >"${new_resources_dir}/README.md"
python "${WORK_DIR}/readme_script.py" "${new_resources_dir}/README.md"

echo "Getting input from AoC website and creating ${input_file} ..."
url="${aoc_url}/20${year}/day/${day}"
curl --cookie "session=${session}" "${url}/input" >"${new_resources_dir}${input_file}"
