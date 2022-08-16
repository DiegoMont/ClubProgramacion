import java.util.Scanner;

public class MinimumVariedNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = Integer.parseInt(sc.nextLine()); 0 < t; t--) {
            int remainder = Integer.parseInt(sc.nextLine());
            int maxValue = 9;
            StringBuilder result = new StringBuilder();
            while(remainder > 0) {
                if(remainder - maxValue >= 0) {
                    result.insert(0, maxValue);
                    remainder -= maxValue;
                }
                maxValue--;
            }
            System.out.println(result.toString());
        }
        sc.close();
    }
}