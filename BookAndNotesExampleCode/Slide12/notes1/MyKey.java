package notes1;

import notes.In;

class MyKey implements KEY 
{
    private int val; // Η τιμή του κλειδιού
    
    public boolean less(KEY w) 
    {
        return val < ((MyKey) w).val;
    }
    
    public boolean equals(KEY w) 
    {
        return val == ((MyKey) w).val;
    }
    
    // Παραδείγματα extra λειτουργιών
    
    public void read() 
    {
        val = In.getInt();
    }
    double M;
    public void rand() 
    {
        
		val = (int) (M * Math.random()); // Μ = μέγιστη τιμή
    }
}
