package notes1;
import notes.In;

class MyItem implements ITEM 
{
    private MyKey bankkey; // Το κλειδί του αντικειμένου
    private float balance; // Το υπόλοιπο

    MyItem() 
    { 
        bankkey = new MyKey(); // Δημιουργία νέου κλειδιού κατά την αρχικοποίηση
    }

    public KEY key() 
    { 
        return bankkey; // Επιστροφή του κλειδιού
    }

    void read() 
    {
        bankkey.read(); // Ανάγνωση του κλειδιού
        balance = In.getFloat(); // Ανάγνωση του υπολοίπου
    }


	public boolean less(ITEM v)
	{
		// TODO Auto-generated method stub
		return false;
	}
}

