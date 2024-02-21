import java.util.Scanner;
public class Q9 {
    // Get input (I or D), from the user, run a loop that adds that number to an accumulator, and then print the result. (gen9.java,program9.class)
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		double accumulator = 0.0;
		double number;
		
		while (true) {
		
			System.out.println("Enter double");
			number = scanner.nextDouble();
			accumulator += number;
			System.out.print("Accumulator: ");
			System.out.println(accumulator);

		}
	    
	  }

}
