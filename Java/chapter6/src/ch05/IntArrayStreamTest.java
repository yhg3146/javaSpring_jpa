package ch05;

import java.util.Arrays;

public class IntArrayStreamTest {
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5};
		
		for(int num :arr) {
			System.out.println(num);
			
		}
		System.out.println();
		Arrays.stream(arr).forEach(n->System.out.println(n));
	}
}
