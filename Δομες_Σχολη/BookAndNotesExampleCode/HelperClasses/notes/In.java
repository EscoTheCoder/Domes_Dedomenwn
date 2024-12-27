package notes;
import java.util.Scanner;
import java.io.IOException;

public class In 
{
    private static int c;

    static Scanner keyboard = new Scanner(System.in);
    private static boolean blank() 
    {
        return Character.isWhitespace((char) c);
    }

    private static void readC() 
    {
        try 
        {
            c = System.in.read();
        } 
        catch (IOException e) 
        {
            c = -1;
        }
    }

    public static void init() 
    {
        readC();
    }

    public static boolean empty() 
    {
        return c == -1;
    }

    public static String getString() 
    {
        if (empty()) 
        {
            return null;
        }
        
        String s = "";
        
        do 
        {
            s += (char) c;
            readC();
        } 
        while (!(empty() || blank()));
        
        while (!empty() && blank()) 
        {
            readC();
        }
        
        return s;
    }

    public static int getInt() 
    {
    	 
//        return Integer.parseInt(getString()); auto itan arxika
    	return keyboard.nextInt();
    }

    public static double getDouble() 
    {
        return Double.parseDouble(getString());
    }

	public static float getFloat()
	{
		// TODO Auto-generated method stub
		return Float.parseFloat(getString());
	}
}

