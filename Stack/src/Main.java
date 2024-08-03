public class Main{
    public static void main(String[] args){

        Stack stack = new Stack(10);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(60);
        stack.push(90);

        System.out.println(stack.top);

        stack.print();

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.print();

    }

}