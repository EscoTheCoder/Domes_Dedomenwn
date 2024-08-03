import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array={9,2,4,7};

        System.out.println(Arrays.toString(array));
        mergesort(array, 0 , array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void mergesort(int[] array, int start, int finish){
        int middle;

        if (start==finish){ // 1 stoixio ston pinaka
            return;
        }
        else if (start==finish-1){ // 2 stoixia ston pinaka
            if(array[start]>array[finish]){
                int temp=array[start];
                array[start]=array[finish];
                array[finish]=temp;
            }
        }
        else {
            middle = (start + finish) / 2;
            mergesort(array, start, middle);
            mergesort(array, middle+1, finish);
            merge(array, start, finish);
        }
    }

    public static void merge(int[] array, int start, int finish){
        int[] C=new int[finish-start+1]; //voithitikos pinakas
        int i,j,k;
        int middle,n,m;

        middle=(start+finish)/2;

        //1os pinakas array[start...middle]=array[i..n]
        i=start;
        n=middle;

        //2os pinakas array[middle+1...finish]=array[j..m]
        j=middle+1;
        m=finish;

        //C: sigxwneumenos pinakas
        k=0;

        //1. Sigxwneush twn 2 pinakwn
        while(i<=n && j<=m){
            if(array[i]<array[j]){
                C[k]=array[i];
                i++;
                k++;
            }
            else{
                C[k]=array[j];
                j++;
                k++;
            }
        }

        //2. Antigrafh tou pinaka pou perissevei sto telos tou sigxwneumenou pinaka
        if(i==n+1){ //Ejantilithike o 1os pinakas
            while(j<=m){
                C[k]=array[j];
                j++;
                k++;
            }
        }
        else{ //Ejantilithike o 1os pinakas
            while(i<=n){
                C[k]=array[i];
                i++;
                k++;
            }
        }

        //3. Antigrafh tou C ston pinaka
        for(i=start; i<C.length; i++){
            array[i]=C[i];
        }
    }
}