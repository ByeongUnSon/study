package lcson.shellsort.test;

public class ShellSort {

	public static void main(String[] args) {
		int[] array = new int[10];
		
		array[0] = 33;
		array[1] = 11;
		array[2] = 99;
		array[3] = 1;
		array[4] = 22;
		array[5] = 88;
		array[6] = 55;
		array[7] = 44;
		array[8] = 66;
		array[9] = 77;
		
		System.out.print("*Input : ");
		displayArray(array);
		System.out.println("");
		shellSort(array);
		
	}

	static int[] shellSort(int[] arr) {
		int h = 1;		// h 값을 1로 지정
		
		while (h <= arr.length / 3) {
			h = h * 3 + 1;				// h 값을 크누스 간격순서에 참고하여 찾는다.
		}
		
		while (h > 0) {		// 삽입 정렬 알고리즘과 동일한 방식
			for (int i=h; i<arr.length; i++) {	// 삽입 정렬할 항목 선택
				int tmp = arr[i];
				int j = i;
				
				while (j>h-1 && arr[j-h] >= tmp) {
					
					// 삽입할 항목보다 작은 값의 항목을 찾을 때 까지 비교
					// 하위 배열내에서 비교 즉, 0, 4, 8
					
					arr[j] = arr[j-h];	// 삽입할 항목보다 큰 값은 오른쪽으로 이동
					
					j -= h;
				}
				arr[j] = tmp;
				displayArray(arr);
				System.out.println();
			}
			h = (h-1) / 3;		// h값을 줄인다.
		}
		return arr;
	}
	
	static void displayArray(int[] arr) {	
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
