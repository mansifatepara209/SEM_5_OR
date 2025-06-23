import java.util.Scanner;

public class One_D_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Length Of Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter Elements Of Array: ");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int P = arr[0];
        for(int j=1;j<n;j++){
           if(arr[j] != P){
            P = arr[j];
           }
           else if(arr[j] == P){
            arr[j] = -1;
           }
        }
        System.out.println("--------------");
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}
