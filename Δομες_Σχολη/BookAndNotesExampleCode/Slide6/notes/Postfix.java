package notes;

class Postfix
{
    public static void main(String[] args)
    {
        // Convert the input string to a character array
        char[] a = args[0].toCharArray();
        int N = a.length;
        
        // Create an integer stack to perform postfix expression evaluation
        ΙntStack s = new ΙntStack(N);
        
        for (int i = 0; i < N; i++)
        {
            if (a[i] == '+')
            {
                // If the current character is '+', pop the top two elements from the stack and push their sum
                s.push(s.pop() + s.pop());
            }
            else if (a[i] == '*')
            {
                // If the current character is '*', pop the top two elements from the stack and push their product
                s.push(s.pop() * s.pop());
            }
            else if ((a[i] >= '0') && (a[i] <= '9'))
            {
                // If the current character is a digit, we need to handle multi-digit numbers
                s.push(0);
                // Continue reading characters while they are digits and build a multi-digit number
                while ((a[i] >= '0') && (a[i] <= '9'))
                {
                    s.push(10 * s.pop() + (a[i++] - '0'));
                }
            }
            // Print the top element of the stack after each operation
            Out.println(s.pop() + "");
        }
    }
}
