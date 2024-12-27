package notes;

class Poly
{
	private int n; // The degree of the polynomial + 1
	private int[] a; // Coefficients

	// Constructor to create the polynomial cx^N
	Poly(int c, int N)
	{
		a = new int[N + 1]; // Initialize the coefficients array with length N + 1
		n = N + 1; // Set the degree of the polynomial to N + 1
		a[N] = c; // Set the coefficient of the highest degree term to c
		for (int i = 0; i < N; i++)
		{
			a[i] = 0; // Initialize all other coefficients to 0
		}
	}

	// Evaluate the polynomial at the given value d
	double eval(double d)
	{
		double t = 0.0; // Result value at d
		for (int i = n - 1; i >= 0; i--)
		{
			t = t * d + (double) a[i]; // Multiply the current result by d and add the coefficient of the term
		}
		return t; // Return the evaluated value of the polynomial
	}

	void add(Poly p)
	{
		int[] t = new int[(p.n > n) ? p.n : n]; // Create a new array t with size equal to the maximum degree of the two
												// polynomials
		for (int i = 0; i < p.n; i++)
			t[i] = p.a[i]; // Copy coefficients from polynomial p to array t
		for (int j = 0; j < n; j++)
			t[j] += a[j]; // Add coefficients from polynomial a to array t
		a = t; // Replace the coefficients array of this polynomial with array t
		n = t.length; // Update the degree of this polynomial
	}

	void mult(Poly p)
	{
		int[] t = new int[p.n + n - 1]; /* Create a new array t with size equal to the sum of the degrees of the two
										 polynomials minus one*/
		for (int i = 0; i < p.n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				t[i + j] += p.a[i] * a[j]; // Perform polynomial multiplication and accumulate the results in array t
			}	
		}
			
		a = t; // Replace the coefficients array of this polynomial with array t
		n = t.length; // Update the degree of this polynomial
	}

	public String toString()
	{
		String s = "";
		for (int i = 0; i < n; i++)
		{
			s += a[i] + " "; // Construct a string representation of the coefficients of this polynomial
		}			
		return s; // Return the string representation
	}

	class Binomial
	{ // Class for computing (x+1)^N
		public static void main(String[] args)
		{
			int N = Integer.parseInt(args[0]); // Parse the input argument as the exponent N
			double d = Double.parseDouble(args[1]); // Parse the input argument as the value d
			Poly y = new Poly(1, 0); // Initialize a polynomial y = 1
			Poly t = new Poly(1, 0); // Initialize a polynomial t = 1
			t.add(new Poly(1, 1)); // Add x+1 to polynomial t
			for (int i = 0; i < N; i++)
			{
				y.mult(t); // Multiply polynomial y by t N times, effectively computing (x+1)^N
			}
			Out.println("value: " + y.eval(d)); // Evaluate the resulting polynomial y at the value d and print the
												// result
		}
	}

}
