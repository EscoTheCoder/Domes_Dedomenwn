import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array={47,30,47,31,26,33,24,17,23,11,23,37,49,2,32};
        
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }
    
    public static void bubbleSort(int[] array){
        int N=array.length;
        for(int i=0; i<N; i++){
            for(int j=N-1; j>i; j--){
                if(array[j]<array[j-1]){
                    int temp=array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
            System.out.print("Vhma "+i+": ");
            System.out.print(Arrays.toString(array)+"\n");
        }
    }
}