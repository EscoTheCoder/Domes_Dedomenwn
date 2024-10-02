import java.util.EmptyStackException;

public class Queue {
    //KUKLIKH OURA
    int[] queue;
    int n; //megethos ths ouras
    int head; //prwto stoixeio ouras
    int tail; //meta to teleutaio stoixeio (ekei pou prepei na bei to epomeno)
    int size;

    public Queue(int n) {
        this.n=n;
        queue = new int[n];
        head=0;
        tail=0;
        size=0;
    }
    public void enqueue(int data){
        if(isFull()){
            throw new IllegalArgumentException();
        }
        queue[tail]=data;
        tail = (tail+1)%n; //circular increment otan (tail+1)=n paei sthn thesh 0
        size++;
    }
    public int dequeue(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        int data=queue[head];
        head = (head+1)%n; //circular increment anadiplwsh otan (head+1)=n
        size--;
        return data;
    }
    public boolean isFull(){
        return size==queue.length;
    }
    public boolean isEmpty(){
        return size==0;
    }
}
