// 2310. Sum of Numbers With Units Digit K
class Solution {
public:
    int minimumNumbers(int num, int k) {
        if(num == 0)
            return 0;
        else if(num % 10 == 0 && k == 0)
            return 1;
        for(int i = 1; i < 11; i++) {
            const int remainder = num - (k * i);
            if(remainder < 0)
                return -1;
            else if(remainder % 10 == 0)
                return i;
        }
        return -1;
    }
};