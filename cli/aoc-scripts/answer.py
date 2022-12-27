import re
import sys

output = []
found_first = False
found_second = False
regex = '`_(.*)_`'
answer = re.compile(regex)
readme_file = sys.argv[1]
test_file = sys.argv[2]
LINE = 'return getInput(0, 0);'

f_in = open(readme_file, "rt")
for line in f_in:
    if answer.search(line):
        result = re.search(regex, line)
        output.append(result.group(1))

while len(output) < 2:
    output.append(0)

f_in = open(test_file, "rt")
f_out = open(f'{test_file}1', "wt")

for line in f_in:
    if LINE not in line:
        f_out.write(line)
    elif not found_first:
        f_out.write(line.replace(LINE, f'return getInput({output[0]}, 0);'))
        found_first = True
    elif not found_second:
        f_out.write(line.replace(LINE, f'return getInput({output[1]}, 0);'))
        found_second = True
