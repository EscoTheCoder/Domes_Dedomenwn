package notes;

public class IntStack2
{
	// This class represents a stack data structure that stores integers.
		 // It utilizes a private instance of the Stack class to manage the stack operations.

		 // Declaration of the private Stack instance variable 'S'.
		 private Stack S;
		
		 // Constructor method for initializing the Stack with a specified maximum capacity.
		 // It instantiates the Stack object with the given maximum capacity.
		 IntStack2(int maxN) 
		 {
		     S = new Stack(maxN);
		 }
		
		 // Method to check if the stack is empty.
		 // It returns true if the stack is empty, otherwise false.
		 boolean isEmpty() 
		 {
		     return S.isEmpty();
		 }
		
		 // Method to push an integer item onto the stack.
		 // It wraps the given integer item into an Integer object and pushes it onto the stack.
		 void push(int item)
		 {
		    // S.push(new Integer(item));deprecated
			  S.push(Integer.valueOf(item));
		 }
		
		 // Method to pop an integer item from the stack.
		 // It pops the top element from the stack, casts it to an Integer, and returns its integer value.
		 int pop() 
		 {
		     return ((Integer) S.pop()).intValue();
		 }
}
