package recursion;

public class Recursiva {
	public static void main (String[] args) {
		sayHi(3);
	} 
	
	public static void sayHi(int count) {
		System.out.println("Hi!");
		if (count <= 1) {
		return;
		}
		
		sayHi(count-1);
	}
}
