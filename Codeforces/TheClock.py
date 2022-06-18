""" THE CLOCK
Victor has a 24-hour clock that shows the time in the format "HH:MM" (00 <= HH <= 23, 00 <= MM <= 59). He looks at the clock every x minutes, and the clock is currently showing time s.
How many different palindromes will Victor see in total after looking at the clock every x minutes, the first time being at time s?
For example, if the clock starts out as 03:12 and Victor looks at the clock every 360 minutes (i.e. every 6 hours), then he will see the times 03:12, 09:12, 15:12, 21:12, 03:12, and the times will continue to repeat. Here the time 21:12 is the only palindrome he will ever see, so the answer is 1.
A palindrome is a string that reads the same backward as forward. For example, the times 12:21, 05:50, 11:11 are palindromes but 13:13, 22:10, 02:22 are not.

INPUT
The first line of the input contains an integer t (1 <= t <= 100) — the number of test cases. The description of each test case follows.
The only line of each test case contains a string s of length 5 with the format "HH:MM" where "HH" is from "00" to "23" and "MM" is from "00" to "59" (both "HH" and "MM" have exactly two digits) and an integer x (1 <= x <= 1440) — the number of minutes Victor takes to look again at the clock.
OUTPUT
For each test case, output a single integer — the number of different palindromes Victor will see if he looks at the clock every x minutes starting from time s.

SAMPLE INPUT
6
03:12 360
00:00 1
13:22 2
15:15 10
11:11 1440
22:30 27

SAMPLE OUTPUT
1
16
10
0
1
1

"""
import datetime


palindrome_times = {
        datetime.timedelta(hours=0, minutes=0),
        datetime.timedelta(hours=1, minutes=10),
        datetime.timedelta(hours=2, minutes=20),
        datetime.timedelta(hours=3, minutes=30),
        datetime.timedelta(hours=4, minutes=40),
        datetime.timedelta(hours=5, minutes=50),
        datetime.timedelta(hours=10,minutes= 1),
        datetime.timedelta(hours=11,minutes= 11),
        datetime.timedelta(hours=12,minutes= 21),
        datetime.timedelta(hours=13,minutes= 31),
        datetime.timedelta(hours=14,minutes= 41),
        datetime.timedelta(hours=15,minutes= 51),
        datetime.timedelta(hours=20,minutes= 2),
        datetime.timedelta(hours=21,minutes= 12),
        datetime.timedelta(hours=22,minutes= 22),
        datetime.timedelta(hours=23,minutes= 32)
    }

def main():
    t = int(input())
    for _ in range(t):
        (lookup_time, period) = parse_input()
        one_day = datetime.timedelta(days=1)
        start_time = lookup_time + one_day
        seen_palindromes = 0
        while start_time != lookup_time:
            start_time = start_time % one_day
            if is_palindrome(lookup_time):
                seen_palindromes += 1
            lookup_time = (lookup_time + period) % one_day
        print(seen_palindromes)


def parse_input():
    inputs = input().split(" ")
    period_minutes = int(inputs[1])
    period = datetime.timedelta(minutes=period_minutes)
    timestring = inputs[0].split(":")
    hours = int(timestring[0])
    minutes = int(timestring[1])
    time = datetime.timedelta(hours=hours, minutes=minutes)
    return (time, period)

def is_palindrome(moment):
    return moment in palindrome_times
    

main()