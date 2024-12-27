package notes;


/*
To convert (A+B) to the postfix form A B +, we ignore the left parenthesis, convert A to postfix, save the + on the stack, convert
B to postfix, then, on encountering the right parenthesis, pop the stack and output the +.
 * */
class InfixToPostfix 
{
    public static void main(String[] args) 
    {
        // Convert the command-line argument to a character array
        char[] a = args[0].toCharArray();
        int N = a.length;
        
        // Create a stack for characters
        CharStack s = new CharStack(N);
        
        for (int i = 0; i < N; i++) 
        {
            // Check if the current character is a closing parenthesis
            if (a[i] == ')') 
            {
                // Pop operator from the stack and print it.
                Out.print(s.pop() + " ");
            }
            // Check if the current character is an operator (+ or *)
            if ((a[i] == '+') || (a[i] == '*')) 
            {
                // Push the operator onto the stack
                s.push(a[i]);
            }
            // Check if the current character is a digit
            if ((a[i] >= '0') && (a[i] <= '9')) 
            {
                // Print the digit
                Out.print(a[i] + " ");
            }
        }
        
        // Print a new line to separate the output
        Out.println("");
    }
} 


