package notes;
import java.time.LocalDate;

public class TestingCopyOfArrays 
{	
	public static void main(String[] args)
	{ 
		 LocalDate[] d = {
		            LocalDate.of(2006, 10, 12),
		            LocalDate.of(2006, 11, 15)
		        };

		        LocalDate[] e = new LocalDate[d.length];

		        for (int i = 0; i < d.length; i++) 
		        {
		            e[i] = d[i];
		        }

		        System.out.println("Output before change");
	            System.out.println("e= "+ e[0]);//2001-10-12
	            System.out.println("d= "+ d[0]);//2006-10-12
	            
		        // Modify e[0]
		        d[0] = d[0].minusYears(5);

		        // Print the updated array	 
		        System.out.println("Output after change");
	            System.out.println("e= "+ e[0]);//2001-10-12
	            System.out.println("d= "+ d[0]);//2006-10-12

	}	
}
