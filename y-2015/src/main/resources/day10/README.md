Getting HTML...
...got HTML
result = null
 Day 10 - Advent of Code 2015     window.addEventListener('click', function(e,s,r){if(e.target.nodeName==='CODE'&&e.detail===3){s=window.getSelection();s.removeAllRanges();r=document.createRange();r.selectNodeContents(e.target);s.addRange(r);}});

[Advent of Code](/)
===================

*   [\[About\]](/2015/about)
*   [\[Events\]](/2015/events)
*   [\[Shop\]](https://teespring.com/stores/advent-of-code)
*   [\[Settings\]](/2015/settings)
*   [\[Log Out\]](/2015/auth/logout)

Adam Jonas 16\*

   0x0000|[2015](/2015)
=======================

*   [\[Calendar\]](/2015)
*   [\[AoC++\]](/2015/support)
*   [\[Sponsors\]](/2015/sponsors)
*   [\[Leaderboard\]](/2015/leaderboard)
*   [\[Stats\]](/2015/stats)

\--- Day 10: Elves Look, Elves Say ---
--------------------------------------

Today, the Elves are playing a game called [look-and-say](https://en.wikipedia.org/wiki/Look-and-say_sequence). They take turns making sequences by reading aloud the previous sequence and using that reading as the next sequence. For example, `211` is read as "one two, two ones", which becomes `1221` (`1` `2`, `2` `1`s).

Look-and-say sequences are generated iteratively, using the previous value as input for the next step. For each step, take the previous value, and replace each run of digits (like `111`) with the number of digits (`3`) followed by the digit itself (`1`).

For example:

*   `1` becomes `11` (`1` copy of digit `1`).
*   `11` becomes `21` (`2` copies of digit `1`).
*   `21` becomes `1211` (one `2` followed by one `1`).
*   `1211` becomes `111221` (one `1`, one `2`, and two `1`s).
*   `111221` becomes `312211` (three `1`s, two `2`s, and one `1`).

Starting with the digits in your puzzle input, apply this process 40 times. What is _the length of the result_?

Your puzzle input is `1113222113`.

Answer:  

You can also \[Shareon [Twitter](https://twitter.com/intent/tweet?text=%22Elves+Look%2C+Elves+Say%22+%2D+Day+10+%2D+Advent+of+Code+2015&url=https%3A%2F%2Fadventofcode%2Ecom%2F2015%2Fday%2F10&related=ericwastl&hashtags=AdventOfCode) [Mastodon](javascript:void(0);)\] this puzzle.

(function(i,s,o,g,r,a,m){i\['GoogleAnalyticsObject'\]=r;i\[r\]=i\[r\]||function(){ (i\[r\].q=i\[r\].q||\[\]).push(arguments)},i\[r\].l=1\*new Date();a=s.createElement(o), m=s.getElementsByTagName(o)\[0\];a.async=1;a.src=g;m.parentNode.insertBefore(a,m) })(window,document,'script','//www.google-analytics.com/analytics.js','ga'); ga('create', 'UA-69522494-1', 'auto'); ga('set', 'anonymizeIp', true); ga('send', 'pageview');
