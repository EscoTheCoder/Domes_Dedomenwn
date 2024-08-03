import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array={9,2,4,7,3,12,25,1,43,79,14};
        bubblesort(array);
        int key=binarySearch_Recursion(array, 0, array.length-1, 25);
        if(key==-1){
            System.out.println("Den vrethike");
        }
        else{
            System.out.println("Vrethike sthn thesh = "+key);
        }
    }

    public static void bubblesort(int[] array){

    }

    //ULOPOIHSH XWRIS ANADROMH
    public static int binarySearch(int[] array,int start, int finish,int key){
        int middle;
        int pos=-1;

        while(start<=finish && pos==-1){
            middle=(start+finish)/2;
            if(array[middle]==key){
                return middle;
            }
            else if(array[middle]<key){
                start=middle+1;
            }
            else{
                finish=middle-1;
            }
        }
        return pos;
    }

    //ULOPOIHSH ME ANADROMH
    public static int binarySearch_Recursion(int[] array,int start, int finish,int key){
        if(start<=finish){
            int middle=(start+finish)/2;

            if(array[middle]==key){
                return middle;
            }
            else if(array[middle]<key){
                return binarySearch_Recursion(array,middle+1,finish,key);
            }
            else{
                return binarySearch_Recursion(array,start,middle-1,key);
            }
        }
        return -1;
    }
}