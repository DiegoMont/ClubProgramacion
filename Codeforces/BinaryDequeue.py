""" BINARY DEQUEUE
Slavic has an array of length n consisting only of zeroes and ones. In one operation, he removes either the first or the last element of the array.
What is the minimum number of operations Slavic has to perform such that the total sum of the array is equal to s after performing all the operations? In case the sum s can't be obtained after any amount of operations, you should output -1.

INPUT
The first line contains a single integer t(1 <= t <= 10000) - the number of test cases.
The first line of each test case contains two integers n and s (1 <= n, s <= 200000) - the length of the array and the needed sum of elements.
The second line of each test case contains n integers ai(0 <= ai <= 1) - the elements of the array.

OUTPUT
For each test case, output a single integer — the minimum amount of operations required to have the total sum of the array equal to s, or -1 if obtaining an array with sum s isn't possible.

SAMPLE INPUT
7
3 1
1 0 0
3 1
1 1 0
9 3
0 1 0 1 1 1 0 0 1
6 4
1 1 1 1 1 1
5 1
0 0 1 1 0
16 2
1 1 0 0 1 0 0 1 1 0 0 0 0 0 1 1
6 3
1 0 1 0 0 0

SAMPLE OUTPUT
0
1
3
2
2
7
-1
"""

def main():
    t = int(input())
    for _ in range(t):
        aux = input().split(" ")
        n = int(aux[0])
        s = int(aux[1])
        a = [int(ai) for ai in input().split(" ")]
        total_sum = 0
        for ai in a:
            total_sum += ai
        if(total_sum < s):
            print(-1)
        else:
            cache = {}
            print(get_min_movements(a, total_sum - s, 0, n-1, cache))

def get_min_movements(a, ones_to_remove, left_index, right_index, cache):
    if ones_to_remove == 0:
        return 0
    call_key = f"{left_index}:{right_index}";
    if call_key in cache:
        return cache[call_key]
    left_remove = get_min_movements(a, ones_to_remove-a[left_index], left_index+1, right_index, cache)
    right_remove = get_min_movements(a, ones_to_remove-a[right_index], left_index, right_index-1, cache)
    cache[call_key] = 1 + min(left_remove, right_remove)
    return cache[call_key]


main()