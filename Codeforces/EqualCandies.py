""" EQUAL CANDIES
There are n boxes with different quantities of candies in each of them. The i-th box has ai candies inside.
You also have n friends that you want to give the candies to, so you decided to give each friend a box of candies. But, you don't want any friends to get upset so you decided to eat some (possibly none) candies from each box so that all boxes have the same quantity of candies in them. Note that you may eat a different number of candies from different boxes and you cannot add candies to any of the boxes.
What's the minimum total number of candies you have to eat to satisfy the requirements?
INPUT
The first line contains an integer t (1 <= t <= 1000) - the number of test cases.
The first line of each test case contains an integer n (1 <= n <= 50) - the number of boxes you have.
The second line of each test case contains n integers a1,a2, ...,an (1 <= ai <= 10^7) - the quantity of candies in each box.
OUTPUT
For each test case, print a single integer denoting the minimum number of candies you have to eat to satisfy the requirements.
SAMPLE INPUT
5
5
1 2 3 4 5
6
1000 1000 5 1000 1000 1000
10
1 2 3 5 1 2 7 9 13 5
3
8 8 8
1
10000000

SAMPLE OUTPUT
10
4975
38
0
0
"""

def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        a = input().split(" ")
        min_candies = 10000000
        total_candies = 0
        for ai in a:
            box = int(ai)
            min_candies = min(box, min_candies)
            total_candies += box
        total_candies -= n * min_candies
        print(total_candies)

main()