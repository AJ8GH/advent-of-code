import sys

install_dir = sys.argv[1]

with open(file) as f_in:
    with open(file) as f_out:
        f_out.write(line.replace('export AOC_INSTALL_DIR=', 'AOC_LEVEL=2'))
