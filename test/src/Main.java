import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int k = 6; // π.χ., k = 6
//        Node n = new Node(k);
//        Node head = n.Fib(k);
//        if (head != null) {
//            n.printList(head, k);
//        }
//        else {
//            System.out.println("The list is empty.");
//        }

        //int[] ar = new ArrayList<>()

//        Date[] d = {new Date(12,10,2006), new Date(15,11,2006)};
//
//        Date[] e = new Date[d.length];
//
//        for(int i=0; i<e.length; i++){
//            e[i] = new Date(d[i].day,d[i].month,d[i].year);
//        }
//
//        for(int i=0; i<e.length; i++){
//            System.out.println(d[i]);
//            System.out.println(e[i]+"\n");
//        }
//
//        e[0].year= 2007;
//
//        for(int i=0; i<e.length; i++){
//            System.out.println(d[i]);
//            System.out.println(e[i]+"\n");
//        }
//        ArrayList<Integer> a = new ArrayList<>();
//
//        int[] nums1 = {1,2,2,1};
//        int[] nums2 = {2,2};
//
//
//        if(nums1.length>nums2.length) {
//            for (int i = 0; i< nums2.length; i++){
//                for(int j=0; j<nums1.length; j++) {
//                    if (nums2[i]==nums1[j]) {
//                        a.add(nums2[i]);
//                    }
//                }
//            }
//        }
//        else{
//            for (int i = 0; i< nums1.length; i++){
//                for(int j=0; j<nums2.length; j++) {
//                    if (nums1[i]==nums2[j]) {
//                        a.add(nums1[i]);
//                    }
//                }
//            }
//        }
//
//        HashSet<Integer> s = new HashSet<>(a);
//
//        int[] nums3 = new int[s.size()];
//
//        int i=0;
//
//        // iterating over the hashset
//        for(Integer ele : s){
//            nums3[i++] = ele;
//        }

        int[] array = {5,3,1,7};

        System.out.println(Arrays.toString(array));

        insertionSort(array);

        System.out.println(Arrays.toString(array));
    }

    /**
     * Sunarthsh Tajinomhshs
     * @param array o pinakas pou prepei na tajinomithei
     */
    public static void bubbleSort(int[] array){
        int N = array.length;
        for(int i=0; i<N; i++){
            for(int j=N-1; j>i; j--){
                if(array[j]<array[j-1]){
                    int temp = array[j];
                    array[j]=array[j-1];
                    array[j-1]=temp;
                }
            }
        }
    }

    public static void selectionSort(int[] array){
        int N = array.length;
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
        }
    }

    public static void insertionSort(int[] array) {

        for(int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }
    }
}