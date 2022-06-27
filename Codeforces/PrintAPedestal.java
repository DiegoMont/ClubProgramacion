/*  PRINT A PEDESTAL
 * Given the integer n - the number of available blocks. You must use all blocks to build a pedestal.
The pedestal consists of 3 platforms for 2-nd, 1-st and 3-rd places respectively. The platform for the 1-st place must be strictly higher than for the 2-nd place, and the platform for the 2-nd place must be strictly higher than for the 3-rd place. Also, the height of each platform must be greater than zero (that is, each platform must contain at least one block).
Among all possible pedestals of n blocks, deduce one such that the platform height for the 1-st place minimum as possible. If there are several of them, output any of them.
INPUT
The first line of input data contains an integer t(1 <= t <= 10000) the number of test cases.
Each test case contains a single integer n(6 <= n <= 100000) the total number of blocks for the pedestal. Allnn blocks must be used.
It is guaranteed that the sum of n values over all test cases does not exceed 10^6.
OUTPUT
For each test case, output 3 numbers h2, h1, h3 - the platform heights for for 2-nd, 1-st and 3-rd places on a pedestal consisting of n blocks.
SAMPLE INPUT
6
11
6
10
100000
7
8

SAMPLE OUTPUT
4 5 2
2 3 1
4 5 1
33334 33335 33331
2 4 1
3 4 1
*/
import java.util.Scanner;

public class PrintAPedestal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(; t > 0; t--) {
            int n = Integer.parseInt(sc.nextLine());
            int remainingBlocks = (n % 3) + 3;
            int baseBlocks = (n - remainingBlocks) / 3;
            int second = baseBlocks, first = baseBlocks, third = baseBlocks;
            if(remainingBlocks == 3) {
                second++;
                first += 2;
            } else if(remainingBlocks == 4) {
                second++;
                first += 3;
            } else {
                second += 2;
                first += 3;
            }
            System.out.println(String.format("%d %d %d", second, first, third));
        }
    }
}
