import java.util.Scanner;

public class Pattern1 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Emter Size Of The Pattern: ");
        int n = sc.nextInt();
        for(int i=n;i>0;i--){
            for(int j=n;j>0;j--){
                System.out.print(" #");
            }
            System.out.println();
        }
    }
}
