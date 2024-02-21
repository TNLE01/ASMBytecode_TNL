import java.util.Scanner;
public class Q8 {
    // Implement If. . . Then . . . Else (gen8.java,program8.class
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter int");

		int number = scanner.nextInt(); 

		if (1 < number)
			System.out.println("Greater than number 1");
		else if (1 == number)
			System.out.println("Equal to number 1");
		else
			System.out.println("Less than number 1");
	    
	  }
}
