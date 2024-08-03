import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array={9,2,4,7};

        System.out.println(Arrays.toString(array));
        SelectionSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void SelectionSort(int[] array){
        int N= array.length;
        int min;

        for(int i=0; i<N; i++){
            min=i;
            for(int j=i+1; j<N; j++){
                if(array[j]<array[min]){
                    min=j;
                }
            }
            int temp=array[i];
            array[i]=array[min];
            array[min]=temp;

            System.out.print("Vhma "+i+": ");
            System.out.print(Arrays.toString(array)+"\n");
        }
    }
}