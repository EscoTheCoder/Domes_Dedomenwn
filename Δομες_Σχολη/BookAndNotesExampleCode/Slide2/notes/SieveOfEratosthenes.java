package notes;
//based on the book
public class SieveOfEratosthenes 
{
	public class Primes 
	{
		
	    public static void main(String[] args) 
	    {
	        // Check if the correct number of command line arguments is provided
	        if (args.length != 1) 
	        {
	            System.out.println("Usage: java Primes <N>");
	            return;
	        }

	        // Parse the value of N from the command line argument
	        int N = Integer.parseInt(args[0]);
	        // Create an array to mark whether each number is prime or not
	        boolean[] isPrime = new boolean[N];

	        // Initialize the array assuming all numbers from 2 to N are prime
	        for (int i = 2; i < N; i++) 
	        {
	            isPrime[i] = true;
	        }

	        // Use the Sieve of Eratosthenes algorithm to mark non-prime numbers
	        for (int i = 2; i < N; i++) 
	        {
	            if (isPrime[i]) 
	            {
	                for (int j = i; j * i < N; j++) 
	                {
	                    // Mark multiples of prime numbers as non-prime
	                    isPrime[i * j] = false;
	                }
	            }
	        }

	        // Print the prime numbers up to N
	        System.out.print("Prime numbers up to " + N + ":");
	        for (int i = 2; i < N; i++) 
	        {
	            if (isPrime[i]) 
	            {
	                System.out.print(" " + i);
	            }
	        }
	        System.out.println();
	    }
	}


}
