import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array={9,2,4,7,3,5,12,-1,132,45,9,8,2,17};

        System.out.println(Arrays.toString(array));
        quicksort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));

    }

    public static void quicksort(int[] array, int start, int finish) {
        int pos;
        if(start<finish){
            pos=partition(array,start,finish);
            quicksort(array,start,pos-1);
            quicksort(array,pos+1,finish);

        }
    }

    public static int partition(int[] array, int start, int finish) {
        int pivot, i, j;

        pivot=array[start];
        i=start+1;
        j=finish;

        while(true){
            while(i <= finish && array[i] <= pivot){ //psaxnoume array[i]>pivot
                i++;
            }
            while(j >= start && array[j] > pivot){ //psaxnoume array[i]<=pivot
                j--;
            }
            if(i<j){ // antallagh tou array[i] me to array[j] efoson i<j
                int temp=array[i];
                array[i]=array[j];
                array[j]=temp;
            }
            else{ // termatizonstas antallazontas to (pivot=array[start]) me to array[j]
                int temp=array[start];
                array[start]=array[j];
                array[j]=temp;
                return j;
            }
        }
    }
}