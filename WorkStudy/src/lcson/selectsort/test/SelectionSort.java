package lcson.selectsort.test;

public class SelectionSort {

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
		selectionSort(array);
	}
	
	static int[] selectionSort(int[] arr) {
		int min;
		
		for (int i=0; i<arr.length-1; i++) {	// 항목 선택
			min = i;	// 가장 작은 값으로 지정
			for (int j=i+1; j<arr.length; j++) {	// 비교해야 할 항목
				if (arr[j] < arr[min]) {
					min = j;	// 가장 작은 값을 변경
				}
			}
			swap(arr, i , min);
			System.out.print("STEP " + (i+1) + " : ");
			displayArray(arr);
			System.out.println();
		}
		return arr;
	}
	
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static void displayArray(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
