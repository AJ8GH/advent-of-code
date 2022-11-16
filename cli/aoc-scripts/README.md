## AOC: CLI Utility For Advent of Code

### Requirements
- Node.js
- Python 3
- ZSH

### Set-up:

Create file `.env` in `aoc-scripts` directory with the following properties:

```
export SESSION=<your-aoc-session-token>
export YEAR=<year>
export DAY=<day>
export LEVEL=<level>
export PROJECT_DIR=<location-of-aoc-project>
export MODULE_DIR=<relative-path-to-module-dir-from-project-dir>
export RESOURCES_DIR=<relative-path-to-resources-dir-from-module-dir>
export SOURCE_DIR=<relative-path-to-source-dir-from-module-dir>
export YEAR_PREFIX=<prefix-for-year-subdirectory>
export DAY_PREFIX=<prefix-for-day-subdirectory>
export AOC_URL=<aoc-url>
export IDE=<ide-or-editor-to-open-project>
export INSTALL_DIR=<install-location>
```

####  Note:
* Session token cookie can be found in the browser dev tools when logged in on the AoC website
* `IDE` value must be an executable in order to work
* `INSTALL_DIR` value must be in PATH for cli to work
* resulting directory structure: 
  * Source: `project-dir/module-dir/source-dir/year-subdirectory/day-subdirectory/`
  * Resources: `project-dir/module-dir/resources-dir/day-subdirectory/`
  * `year-subdirectory` == year-prefix{year}
  * `day-subdirectory` == day-prefix{day}
  * `YEAR_PREFIX`: leave blank to omit year subdirectory
  * `DAY_PREFIX`: default value: `d`

### Usage:

Run executable with `aoc` command

#### Flags

`-i`

_Install_:
* Creates necessary symlinks to make aoc executable findable on `PATH`
---

`-u`

_Uninstall_:
* Removes symlinks to `aoc` executable from `PATH`
---

`-a <answer>`

_Submit_:
* Submits parameter as answer for selected year, day and level
---

`-D <new-day>`

_New Day_:
* Overrides `DAY` environment variable
---

`-Y <new-year>`

_New Year_:
* Overrides `YEAR` environment variable
---

`-L <new-level>`

_New Level_:
* Overrides `LEVEL` environment variable
---

`-c`

_Create_:
* Creates empty src and resources directories for selected year and day
* Creates input and example files
* Gets input from AoC website to create input file
* Gets problem description from AoC website to create `README.md` and formats into Markdown
---

`-s`

_Set_:
* Sets the `YEAR`, `DAY` and `LEVEL` environment variables to the values passed to `-Y`, `-D` and `-L` respectively
* Missing parameters are left unchanged
---

`-n`

_Next_:
* Advances to the next level
* Without parameters, advances one level, advancing the day if already on level 2, and advancing year if already on day 25, level 2
* With `-y` parameter, advances one year, keeping day and level the same
* With `-d` parameter, advances one day, keeping year and level the same unless day is 25, in which case year will advance by 1
* With `-l` parameter, advances one level, keeping day and year the same unless level is 2, in which case day will advance by 1
* `-y`, `-d` and `-l` can be combined to advance all or some of the fields, e.g. `aoc -nydl`
* Using `-l` by itself, e.g. `aoc -nl` is unnecessary as this is the default behaviour of `-n`, but can be combined with `-y` and `-d` to force an advance of level
---

`-O <ide>`
  
_Open_:
* Opens AoC project with chosen IDE
---

`-o`

_Open_:
* Opens AoC project with default IDE
---

`-e`

_Echo_:
* Echoes current values for `YEAR`, `DAY` and `LEVEL` to the shell
---

`-h`

_Help_:
* Show help
