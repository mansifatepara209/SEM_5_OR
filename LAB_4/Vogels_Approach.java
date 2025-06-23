package LAB_4;

import java.util.Scanner;

public class Vogels_Approach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns ");
        // n is for rows
        int n = sc.nextInt();
        // m is for columns
        int m = sc.nextInt();
        int[][] cost = new int[n][m];
        System.out.println("Enter the elements of the Cost matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
    }
}
