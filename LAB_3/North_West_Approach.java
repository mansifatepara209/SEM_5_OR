package LAB_3;

import java.util.Scanner;

public class North_West_Approach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of rows and columns: ");
        // for rows
        int n = sc.nextInt();
        // for columns
        int m = sc.nextInt();
        int[][] cost = new int[n][m];
        // Input from user for cost matrix
        System.out.println("Enter the cost matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cost[i][j] = sc.nextInt();
            }
        }
        int[] supply = new int[n];
        int[] demand = new int[m];
        System.out.println("Enter the supply for each row: ");
        for (int i = 0; i < n; i++) {
            supply[i] = sc.nextInt();
        }
        System.out.println("Enter the demand for each column: ");
        for (int j = 0; j < m; j++) {
            demand[j] = sc.nextInt();
        }

        int[][] allocation = new int[n][m];
        int totalSupply = 0;
        int totalDemand = 0;
        for (int i = 0; i < n; i++) {
            totalSupply += supply[i];
        }
        for (int j = 0; j < m; j++) {
            totalDemand += demand[j];
        }
        if (totalSupply != totalDemand) {
            System.out.println("Supply and Demand do not match. Please check the input!!");
            return;
        }
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (supply[i] == 0) {
                i++;
                continue;
            }
            if (demand[j] == 0) {
                j++;
                continue;
            }
            int allocationAmount = Math.min(supply[i], demand[j]);
            allocation[i][j] = allocationAmount;
            supply[i] -= allocationAmount;
            demand[j] -= allocationAmount;
        }
        System.out.println("Allocation matrix:");
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                System.out.print(allocation[x][y] + " ");
            }
            System.out.println();
        }
        System.out.print("Total Cost: ");
        int totalCost = 0;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < m; y++) {
                totalCost += allocation[x][y] * cost[x][y];
            }
        }
        System.out.println(totalCost);
        sc.close();
        System.out.println("North West Approach completed successfully.");
    }
}
