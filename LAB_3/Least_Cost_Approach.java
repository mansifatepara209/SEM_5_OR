package LAB_3;

import java.util.Scanner;

public class Least_Cost_Approach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 3;
        int m = 4;

        int[][] cost = {
                { 12, 10, 12, 13 },
                { 7, 11, 8, 14 },
                { 6, 16, 11, 7 }
        };

        int[] supply = { 500, 300, 200 };
        int[] demand = { 180, 150, 350, 320 };

        int[][] allocation = new int[n][m];

        int totalSupply = 0, totalDemand = 0;
        for (int s : supply)
            totalSupply += s;
        for (int d : demand)
            totalDemand += d;

        if (totalSupply != totalDemand) {
            System.out.println("Supply and demand are not equal. Please check the inputs!");
            return;
        }

        while (true) {
            int minCost = Integer.MAX_VALUE;
            int minRow = -1, minCol = -1;

            // Find the cell with the minimum cost
            for (int i = 0; i < n; i++) {
                if (supply[i] == 0)
                    continue;
                for (int j = 0; j < m; j++) {
                    if (demand[j] == 0)
                        continue;
                    if (cost[i][j] < minCost) {
                        minCost = cost[i][j];
                        minRow = i;
                        minCol = j;
                    }
                }
            }

            // all allocations done
            if (minRow == -1 || minCol == -1)
                break;

            // Allocate
            int allocated = Math.min(supply[minRow], demand[minCol]);
            allocation[minRow][minCol] = allocated;
            supply[minRow] -= allocated;
            demand[minCol] -= allocated;
        }

        System.out.println("\nAllocation Matrix:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(allocation[i][j] + "\t");
            }
            System.out.println();
        }

        int totalCost = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                totalCost += allocation[i][j] * cost[i][j];

        System.out.println("\nTotal Transportation Cost: " + totalCost);
        System.out.println();
        System.out.println("Least Cost Matrix is completed!");
        System.out.println();

        sc.close();
    }
}