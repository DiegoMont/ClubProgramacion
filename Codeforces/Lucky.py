""" LUCKY?
A ticket is a string consisting of six digits. A ticket is considered lucky if the sum of the first three digits is equal to the sum of the last three digits. Given a ticket, output if it is lucky or not. Note that a ticket can have leading zeroes.
INPUT
The first line of the input contains an integer t (1 <= t <= 1000) - the number of testcases.
The description of each test consists of one line containing one string consisting of six digits.
OUTPUT
Output t lines, each of which contains the answer to the corresponding test case. Output "YES" if the given ticket is lucky, and "NO" otherwise.
SAMPLE INPUT
5
213132
973894
045207
000000
055776

SAMPLE OUTPUT
YES
NO
YES
YES
NO
"""

t = int(input())
for _ in range(t):
    ticket = input()
    a = int(ticket[0]) + int(ticket[1]) + int(ticket[2])
    b = int(ticket[3]) + int(ticket[4]) + int(ticket[5])
    if a == b:
        print('YES')
    else:
        print('NO')