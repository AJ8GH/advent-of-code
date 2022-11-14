import sys

file = sys.argv[1]

with open(file) as f:
    lines = f.readlines()

with open(file, 'w') as f:
    do_write = False
    for line in lines:
        if '--- Day' in line:
            do_write = True
        if 'Answer:' in line or 'Shareon' in line:
            do_write = False
        if do_write:
            f.write(line)
