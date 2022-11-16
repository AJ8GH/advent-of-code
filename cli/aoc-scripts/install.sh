#!/bin/zsh

BASE_DIR=$(readlink -f "$(dirname "${0}")")
source "${BASE_DIR}/.env"

install_dir=${INSTALL_DIR}

ln -s "${BASE_DIR}/../aoc" "${install_dir}"
ln -s "${BASE_DIR}" "${install_dir}"
