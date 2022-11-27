#!/bin/zsh

base_dir=$(readlink -f "$(dirname "${0}")")
env_dirname="${base_dir}/envs"
source "${env_dirname}/current.env"
source "${env_dirname}/${AOC_ENV_FILE}"

if [[ -n "${AOC_INSTALL_DIR}" ]]; then
  echo "AOC is already installed. To reinstall, run <aoc -u> to uninstall then run <aoc -i>"
  exit 1
fi

echo 'Install location (~/.local/bin/):'
read -r install_dir

echo 'Add install location to PATH? (y/n):'
read -r add_to_path

if [[ ${add_to_path} == 'y' ]]; then
  echo -n "export PATH=${install_dir}/.local/bin:${PATH}" >>~/.zshrc
fi

_resolve_install_dir() {
  if [[ -z ${install_dir} ]]; then
    install_dir="${HOME}/.local/bin/"
    mkdir -p "${install_dir}"
  fi
}

_install() {
  ln -s "${base_dir}/../aoc" "${install_dir}"
  ln -s "${base_dir}" "${install_dir}"
}

_resolve_install_dir
_install

echo "export AOC_INSTALL_DIR=${install_dir}" >> "${env_dirname}/${AOC_ENV_FILE}"
