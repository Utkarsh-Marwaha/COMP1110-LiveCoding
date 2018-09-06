import java.util.Scanner;

public class ArrayEquilibrium {
    private static int arrayEquilibrium(int[] arr){

        int rightSum = 0;
        for (int i: arr){
            rightSum+=i;
        }

        int leftSum = 0;
        for(int i = 0; i < arr.length; i++){

            // keep chipping away the right sum one element at a time
            rightSum-=arr[i];
            if (rightSum==leftSum){
                return i;
            }
            // keep incrementing the left sum one element at a time
            leftSum+=arr[i];
        }

        // we will reach here if there is no equilibrium point
        return -1;
    }

    public static void main(String[] args) {
        // declaring a new Scanner object
        Scanner in = new Scanner(System.in);

        // Asking the user to enter a new string
        System.out.println("Enter size of array: ");
        int n = in.nextInt();

        //declaring the array
        int[] array = new int[n];

        // Asking the user to enter the array elements
        for (int i = 0; i<n; i++){
            System.out.println("Enter element "+i);
            array[i] = in.nextInt();
        }
        System.out.println(arrayEquilibrium(array));
    }
}
