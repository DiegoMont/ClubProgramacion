import java.util.Scanner;

public class BlackAndWhiteStripe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(; t > 0; t--) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String stripe = sc.nextLine();
            int minNumberOfChanges = 0;
            int i;
            for(i = 0; i < k; i++) {
                char cellColour = stripe.charAt(i);
                if(cellColour == 'W')
                    minNumberOfChanges++;
            }
            int currentNumChanges = minNumberOfChanges;
            for(; i < n; i++) {
                char beginCellColour = stripe.charAt(i - k);
                char endCellColour = stripe.charAt(i);
                currentNumChanges += endCellColour == 'W' ? 1: 0;
                if(beginCellColour == 'W')
                    currentNumChanges--;
                if(minNumberOfChanges > currentNumChanges && currentNumChanges >= 0)
                    minNumberOfChanges = currentNumChanges;
            }
            System.out.println(minNumberOfChanges);
        }
        sc.close();
    }
}