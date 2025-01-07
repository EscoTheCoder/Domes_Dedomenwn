import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        PQ pQ = new PQ(5);

        pQ.insert(4);
        pQ.insert(1);
        pQ.insert(7);
        pQ.insert(3);

        pQ.print();

//        for(int i=0; i<3; i++) {
//            System.out.println(pQ.getMax());
//        }
    }
}