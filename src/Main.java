import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n+1];
            arr[0] = 0;
            for (int j = 1; j <= n; j++) {
                arr[j] = sc.nextInt();
            }
            int max = 0;
            for(int j = 0; j < n; j++){
                int diff = arr[j+1] - arr[j];
                max = Math.max(max, diff);
            }
            max = Math.max(max, (x-arr[n])*2);
            System.out.println(max);
        }
        sc.close();
    }
}
