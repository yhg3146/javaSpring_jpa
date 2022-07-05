package chapter8;

public class BinarySearchProblem {

	public static void main(String[] args) {

		int[] numbers = {12,25,31,48,54,66,70,83,95,108};
		
		int target =13;
		
		int left=0;
		int right = numbers.length-1;
		int middle = (left + right)/2;
		
		int temp = numbers[middle];
		boolean find = false;
		while (left <= right) {
			
			if(temp == target) {
				find = true;
				break;
			}
			else if(temp > target) {
				right=middle-1;
			}
			else {
				left=middle+1;
			}
			middle = (left+right)/2;
			temp = numbers[middle];
		}
		if(find == true) {
			System.out.println("찾는 수는 "+(middle+1)+"번째에 있습니다.");
		}
		else {
			System.out.println("찾는 수가 없습니다.");
		}
	}

}
