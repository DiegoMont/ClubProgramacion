def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        a = [int(ai) for ai in input().split(' ')]
        b = [int(ai) for ai in input().split(' ')]
        canTransform(a, b, n)
    
                
def canTransform(a, b, n):
    max_difference = 0
    for i in range(n):
        current_difference = a[i] - b[i]
        max_difference = max(max_difference, current_difference)
    for i in range(n):
        a[i] -= max_difference
        if a[i] < 0:
            a[i] = 0
        if a[i] != b[i]:
            return print("NO")
    print("YES")


main()