package recursion;


import java.util.HashMap;

public class Fibonacci {
	static HashMap<String,Long> fibMap = new HashMap<>();
	static HashMap<String,Double> fastInverseFibMap = new HashMap<>();
	static double sum = 0;
	public static void main(String[] args) {
		fibMap.put("0",(long) 0);
		fibMap.put("1", (long) 1);
		fastInverseFibMap.put("0", (double)0);
		fastInverseFibMap.put("1", (double)1);
		fastInverseFibMap.put("2", (double)1);
		
		/*
		long startTime = System.nanoTime();
		System.out.println(fib(50)); 
		long endTime = System.nanoTime();

		long duration = (endTime - startTime);
		System.out.println("the program took " + duration/1000000 + "ms, with normal Fib");
		*/
		//System.out.println("Inverse fib:");
		System.out.println(inverseFib(5));
		System.out.println(fastInverseFibMap);
		System.out.println("fast fib: ");
		System.out.println(fastFib(10));
		System.out.println(fibMap);
		System.out.println("summatoria");
		System.out.println(summatory());
		
	
		/*
		startTime = System.nanoTime();
		System.out.println(fastFib(50)); 
		endTime = System.nanoTime();
		
		duration = (endTime - startTime);
		System.out.println("the program took " + duration/1000000 + "ms, with fastFib");
		*/
		
	}
	
	public static long fib(long num) {
		long fib0 =0;
		long fib1 =1;
		
		if(num==0) {
			return fib0;
		}
		if(num==1) {
			return fib1;
		}
		
		return fib(num-1) + fib(num-2);
		
		
		
	}
	
	public static long fastFib(long num) {
		long fib0 =0;
		long fib1 =1;
		
		if(fibMap.containsKey(String.valueOf(num))){
			return fibMap.get(String.valueOf(num));
		}
		if(num==0) {
			return fib0;
		}
		if(num==1) {
			return fib1;
		}
		fibMap.put(String.valueOf(num), fastFib(num-1) + fastFib(num-2));
		
		return fastFib(num-1) + fastFib(num-2);
		
	}
	
	public static double inverseFib(double num) {
		double fib0 =0;
		double fib1 =1/1;
		double fib2 = 1;
		
		
		if(fastInverseFibMap.containsKey(String.valueOf(num))){
			return fastInverseFibMap.get(String.valueOf(num));
		}
		if(num==2) {
			return  fib2;
		}
		if(num==0) {
			return fib0;
		}
		if(num==1) {
			return fib1;
		}
		fastInverseFibMap.put(String.valueOf((int)num), (1/(inverseFib(num-1)) +  (1/inverseFib(num-2))));
		System.out.println("what is fib: " + 1/inverseFib(num-2));
		return (1/inverseFib(num-1)) + (1/inverseFib(num-2) + (1/inverseFib(num-1)));
	}
	
	public static double summatory() {
		
		for(int i = 1;i<fastInverseFibMap.size();i++) {
			sum += (1/fastInverseFibMap.get(String.valueOf(i)));
			
			System.out.println(fastInverseFibMap.get(String.valueOf(i)));
		}
		//el hashmap fibMap trabaja con enterospor eso estoy ssumando puros ceros
		//usar el inverseFib que usa los doubles. tratar de arreglar ese para que funcione.
		System.out.println((1/fastInverseFibMap.get(String.valueOf(3))));
		System.out.println("this is sum: " + sum);
		return sum;
		
	}
}
