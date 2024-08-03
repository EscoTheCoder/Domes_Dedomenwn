import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array={9,2,4,7};

        System.out.println(Arrays.toString(array));
        InsertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void InsertionSort(int[] array){
        int N= array.length;

        for(int i=1; i<N; i++){
            for(int j=i; j>=1; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
            System.out.print("Vhma "+i+": ");
            System.out.print(Arrays.toString(array)+"\n");
        }
    }
}