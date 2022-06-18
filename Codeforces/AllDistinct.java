/*  ALL DISTINCT
Sho has an array a consisting of n integers. An operation consists of choosing two distinct indices i and j and removing ai and aj from the array.
For example, for the array [2,3,4,2,5], Sho can choose to remove indices 1 and 3. After this operation, the array becomes [3,2,5]. Note that after any operation, the length of the array is reduced by two.
After he made some operations, Sho has an array that has only distinct elements. In addition, he made operations such that the resulting array is the longest possible.
More formally, the array after Sho has made his operations respects these criteria:
- No pairs such that (i < j) and ai = aj exist.
- The length of a is maximized.

Output the length of the final array.
INPUT
The first line contains a single integer t (1 <= t <= 1000) - the number of test cases.
The first line of each test case contains a single integer n (1 <= n <= 50) - the length of the array.
The second line of each test case contains n integers ai (1 <= ai <= 10000) - the elements of the array.

OUTPUT
For each test case, output a single integer - the length of the final array. Remember that in the final array, all elements are different, and its length is maximum.

SAMPLE INPUT
4
6
2 2 2 3 3 3
5
9 1 9 9 1
4
15 16 16 15
4
10 100 1000 10000

SAMPLE OUTPUT
2
1
2
4

*/

import java.util.HashSet;
import java.util.Scanner;

public class AllDistinct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(; 0 < t; t--) {
            int n = Integer.parseInt(sc.nextLine());
            HashSet<Integer> uniqueNumbers = new HashSet<>();
            int repeatedNumbers = 0;
            for (int i = 0; i < n; i++) {
                int ai = Integer.parseInt(sc.next());
                boolean numberAlreadyThere = !uniqueNumbers.add(ai);
                if(numberAlreadyThere)
                    repeatedNumbers++;
            }
            sc.nextLine();
            int arraySize = uniqueNumbers.size();
            if((repeatedNumbers & 1) == 1)
                arraySize--;
            System.out.println(arraySize);
        }
        sc.close();
    }
}