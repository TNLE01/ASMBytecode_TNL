
public class Q4 {
    // Compare two numbers (I, S, L) to determine which is bigger and print it (gen4.java,program4.class)
	public static void main(String[] args) {
		int int1 = 3;
    	int int2 = 2;
    	short short1 = 10;
    	short short2 = 5;
    	long long1 = 200;
    	long long2 = 100;
    
    	if(int1 > int2) {
    		System.out.print(int1);
    		System.out.print(" is bigger than ");
    		System.out.println(int2);
    	}	
    	else {
    		System.out.print(int2);
    		System.out.print(" is bigger than ");
    		System.out.println(int1);
    	}
    	
    	if(short1 > short2) {
    		System.out.print(short1);
			System.out.print(" is bigger than ");
			System.out.println(short2);}
		else {
			System.out.print(short2);
			System.out.print(" is bigger than ");
			System.out.println(short1);
		}

    	if(long1 > long2){
    		System.out.print(long1);
			System.out.print(" is bigger than ");
			System.out.println(long2);}
		else {
			System.out.print(long2);
			System.out.print(" is bigger than ");
			System.out.println(long1);
		}

    }
}
