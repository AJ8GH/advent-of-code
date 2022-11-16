#!/bin/zsh

BASE_DIR=$(readlink -f "$(dirname "${0}")")
source "${BASE_DIR}/.env"

install_dir=${INSTALL_DIR}

rm "${install_dir}/aoc-scripts"
rm "${install_dir}/aoc"
