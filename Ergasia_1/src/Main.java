import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        InfixToPostfix i_p = new InfixToPostfix();

        String infixExpression = "A+B*C+D";
        String postfixExpression = i_p.infixToPostfix(infixExpression);
        System.out.println("Infix Expression: " + infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}