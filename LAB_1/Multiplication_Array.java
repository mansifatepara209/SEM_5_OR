import java.util.Scanner;

public class Multiplication_Array {
    public static void main(String Args[]){
         Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length Of Array1: ");
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr1 = new int[m][n];
        int[][] arr2 = new int[m][n];
        int[][] arr3 = new int[m][n];

        System.out.println("Enter Elements Of The Array1: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter Elements Of The Array2: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr2[i][j] = sc.nextInt();
            }
        }

        System.out.println("Addition Of The Array1 And Array2: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr3[i][j] = arr1[i][j] * arr2[i][j];
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr3[i][j]);
            }
            System.out.println();
        }
    }
}
