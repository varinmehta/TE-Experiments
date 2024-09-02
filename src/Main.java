import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i<n; i++){
            int m = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            if(isPerfectSquare(m)){
                int temp = (int)Math.sqrt(m);
                boolean check = true;
                for(int j = 0; j<(temp-1)*2; j++){
                    if(s.charAt(j)!='1'){
                        check = false;
                        break;
                    }
                }
                if(check) {
                    for (int j = (temp - 1) * 2; j < m - (temp - 1) * 2; j++) {
                        if (s.charAt(j) != '0') {
                            check = false;
                            break;
                        }
                    }
                }
                if(check) {
                    for (int j = m - (temp - 1) * 2; j < m; j++) {
                        if (s.charAt(j) != '1') {
                            check = false;
                            break;
                        }
                    }
                }
                if(check){
                    if(m%2==0) System.out.println("YES");
                }
                if(!check) System.out.println("NO");
                else System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
    public static boolean isPerfectSquare(int x)
    {
        if (x >= 0) {
            int sr = (int)Math.sqrt(x);
            return (sr * sr == x);
        }
        return false;
    }
}
