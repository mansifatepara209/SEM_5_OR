import java.util.Scanner;

public class Two_D_Array {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length Of Array: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[m][n];

        System.out.println("Enter Elemnets Of the Array");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println("-----------");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println("Tranpose Of The Given Array: ");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[j][i]);
            }
            System.out.println();
        }
    }
}
