import java.util.Scanner;

public class GetZMaximumWithX1OrX2 {
    public static void main(String[] args) {
        int maxZ = 0;
        int getX1 = 0, getX2 = 0;

        for (int x1 = 0; x1 <= 4; x1++) {
            for (int x2 = 0; x2 <= 4; x2++) {
                if (x1 + x2 <= 4) {
                    int z = 3 * x1 + 2 * x2;
                    if (z > maxZ) {
                        maxZ = z;
                        getX1 = x1;
                        getX2 = x2;
                    }
                }
            }
        }

        System.out.println("Maximum Z = " + maxZ);
        System.out.println("Best x1 and X2 = " + getX1 + ", x2 = " + getX2);
    }
}

// public class GetZMaximumWithX1OrX2 {
// public static void main(String[] arg) {
// int x1 = 2;
// int x2 = 1;
// int z;
// int temp = 0;
// if ((x1 + x2) <= 4 && x1 >= 0 && x2 >= 0) {
// z = 3 * x1 + 2 * x2;
// if (z > temp) {
// z = temp;
// }
// }
// System.out.println("-----");
// }
