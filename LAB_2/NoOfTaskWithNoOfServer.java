//distribute task across to minimize process time
//objective: distribute tasks across servers to minimize the amximum processing time on any server 
// example: 3 task with processing time:10,20,30 2servers
//we want to assign task to servers such that the load is balance

import java.util.Scanner;

public class NoOfTaskWithNoOfServer {
    public static void main(String[] args) {
        int[] task = { 10, 20, 30 };
        int numServer = 2;
        int[][] binaryArray = new int[8][3];

        for (int i = 0; i < 8; i++) {
            binaryArray[i][0] = (i >> 2) & 1; // First bit
            binaryArray[i][1] = (i >> 1) & 1; // Middle bit
            binaryArray[i][2] = i & 1; // Last bit
        }
        for (int i = 0; i < 8; i++) {
            System.out.print(i + "= [");
            for (int j = 0; j < 3; j++) {
                System.out.print(binaryArray[i][j]);
                if (j < 2)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}