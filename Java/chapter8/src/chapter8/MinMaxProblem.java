package chapter8;

public class MinMaxProblem {

	public static void main(String[] args) {
		
		int[] numbers = {10,55,23,2,79,101,16,82,30,45};
		
		int min = numbers[0];
		int max = numbers[0];
		int minPos =0;
		int maxPos=0;
		for(int i=0; i< numbers.length;i++) {
			if(numbers[i] <=min) {
				min = numbers[i];
				minPos = i+1;
				
			}
			if(numbers[i] >= max) {
				max = numbers[i];
				maxPos = i+1;
			}
		}
		
		System.out.println("가장 큰 값은 " + max + "이고, 위치는 " + maxPos + "번째 입니다.");
		System.out.println("가장 작은 값은 " + min + "이고, 위치는 " + minPos + "번째 입니다.");

		

	}

}
