package lcson.bubblesort.test;

public class BubbleSort {

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
		System.out.println();
		bubbleSort(array);		
	}
	
	static int[] bubbleSort(int[] arr) {
		for (int i=arr.length - 1; i>=0; i--) {		// 비교항목에 대한 범위 정함
			for (int j=0; j<i; j++) {	// 범위 내 항목 비교
				if (arr[j] > arr[j+1]) {	// 인접한 항목 비교
					swap(arr, j, j+1);		// 큰 값과 작은 값을 치환
				}
			}
			System.out.print("STEP " + (arr.length -i) + " : ");
			displayArray(arr);
			System.out.println();
		}
		return arr;
	}
	
	// 치환
	static void swap(int[] arr, int i, int j) {	
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
		
	// 배열의 항목 출력
	static void displayArray(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
