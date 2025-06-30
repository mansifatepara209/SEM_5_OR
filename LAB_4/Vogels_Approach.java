package LAB_4;

public class Vogels_Approach {
    public static void main(String[] args) {
        int[][] cost = {
                { 12, 10, 12, 13 },
                { 7, 11, 8, 14 },
                { 6, 16, 11, 7 },
        };
        int[] supply = { 500, 300, 200 };
        int[] demand = { 180, 150, 350, 320 };

        vogels_approach(cost, supply, demand);
    }

    static void vogels_approach(int[][] cost, int[] supply, int[] demand) {
        int m = supply.length;
        int n = demand.length;

        int[][] allocation = new int[m][n];
        boolean[] rowDone = new boolean[m];
        boolean[] colDone = new boolean[n];

        while (!isDone(rowDone) && !isDone(colDone)) {
            int maxPenalty = -1;
            int selectedRow = -1, selectedCol = -1;
            boolean isRow = true;

            // Row penalties
            for (int i = 0; i < m; i++) {
                if (!rowDone[i]) {
                    int[] penalties = findTwoSmallest(cost[i], colDone);
                    int penalty = penalties[1] - penalties[0];
                    if (penalty > maxPenalty) {
                        maxPenalty = penalty;
                        selectedRow = i;
                        isRow = true;
                    }
                }
            }

            // Column penalties
            for (int j = 0; j < n; j++) {
                if (!colDone[j]) {
                    int[] col = new int[m];
                    for (int i = 0; i < m; i++)
                        col[i] = cost[i][j];
                    int[] penalties = findTwoSmallest(col, rowDone);
                    int penalty = penalties[1] - penalties[0];
                    if (penalty > maxPenalty) {
                        maxPenalty = penalty;
                        selectedCol = j;
                        isRow = false;
                    }
                }
            }

            boolean allocated = false;

            if (isRow && selectedRow != -1) {
                int minCost = Integer.MAX_VALUE;
                int minCol = -1;

                for (int j = 0; j < n; j++) {
                    if (!colDone[j] && cost[selectedRow][j] < minCost) {
                        minCost = cost[selectedRow][j];
                        minCol = j;
                    }
                }

                if (minCol != -1) {
                    int alloc = Math.min(supply[selectedRow], demand[minCol]);
                    allocation[selectedRow][minCol] = alloc;
                    supply[selectedRow] -= alloc;
                    demand[minCol] -= alloc;

                    if (supply[selectedRow] == 0)
                        rowDone[selectedRow] = true;
                    if (demand[minCol] == 0)
                        colDone[minCol] = true;

                    allocated = true;
                }
            } else if (selectedCol != -1) {
                int minCost = Integer.MAX_VALUE;
                int minRow = -1;

                for (int i = 0; i < m; i++) {
                    if (!rowDone[i] && cost[i][selectedCol] < minCost) {
                        minCost = cost[i][selectedCol];
                        minRow = i;
                    }
                }

                if (minRow != -1) {
                    int alloc = Math.min(supply[minRow], demand[selectedCol]);
                    allocation[minRow][selectedCol] = alloc;
                    supply[minRow] -= alloc;
                    demand[selectedCol] -= alloc;

                    if (supply[minRow] == 0)
                        rowDone[minRow] = true;
                    if (demand[selectedCol] == 0)
                        colDone[selectedCol] = true;

                    allocated = true;
                }
            }

            // fallback in case no allocation happened
            if (!allocated) {
                outer: for (int i = 0; i < m; i++) {
                    if (!rowDone[i]) {
                        for (int j = 0; j < n; j++) {
                            if (!colDone[j]) {
                                int alloc = Math.min(supply[i], demand[j]);
                                allocation[i][j] = alloc;
                                supply[i] -= alloc;
                                demand[j] -= alloc;
                                if (supply[i] == 0)
                                    rowDone[i] = true;
                                if (demand[j] == 0)
                                    colDone[j] = true;
                                break outer;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Done. Printing result...");
        printAllocation(allocation, cost);
    }

    private static boolean isDone(boolean[] done) {
        for (boolean b : done)
            if (!b)
                return false;
        return true;
    }

    private static int[] findTwoSmallest(int[] arr, boolean[] done) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (!done[i]) {
                if (arr[i] < min1) {
                    min2 = min1;
                    min1 = arr[i];
                } else if (arr[i] < min2) {
                    min2 = arr[i];
                }
            }
        }
        return new int[] { min1, min2 };
    }

    private static void printAllocation(int[][] allocation, int[][] cost) {
        int totalCost = 0;
        System.out.println("Allocation Matrix:");
        for (int i = 0; i < allocation.length; i++) {
            for (int j = 0; j < allocation[0].length; j++) {
                System.out.printf("%4d", allocation[i][j]);
                totalCost += allocation[i][j] * cost[i][j];
            }
            System.out.println();
        }
        System.out.println("Total Transportation Cost = " + totalCost);
    }
}
