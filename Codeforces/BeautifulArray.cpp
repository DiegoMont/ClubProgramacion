#include <algorithm>
#include <stdio.h>

int main() {
    int t;
    scanf("%d\n", &t);
    for(; t > 0; t--) {
        long long int n, k, b, s;
        scanf("%lld %lld %lld %lld\n", &n, &k, &b, &s);
        if(k * b > s) {
            puts("-1");
            continue;
        }
        long long int* result = new long long int[n] {};
        result[0] = k * b;
        s -= result[0];
        for(size_t i = 1; i < n; i++) {
            result[i] += std::min(k-1, s);
            s -= result[i];
        }
        if(s / k > 0) {
            puts("-1");
            continue;
        } else
            result[0] += std::min(k-1, s);
        for (size_t i = 0; i < n; i++)
            printf("%lld ", result[i]);
        delete[] result;
        puts("");
    }
}