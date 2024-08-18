public class Main {
    public static void main(String[] args) {
        StringDoubleEndedQueueImpl s=new StringDoubleEndedQueueImpl();
        s.addLast("nikos");
        s.addLast("aris");
        s.addLast("kostas");
        s.addLast("babis");

        s.printQueue();

        System.out.println(s.getFirst()+" "+s.getLast());

        s.removeFirst();
        s.removeLast();
        s.addFirst("elpida");


        s.printQueue();
    }
}