package lcson.mergesort.test;

public class MergeSort {
	
	static int array3[] = new int[9];

	static int recursive_num = 4;
	
	public static void main(String[] args) {
		int array1[] = {20, 40, 80, 90};
		int array2[] = {10, 30, 50, 60, 70};
		
		mergeSort(recursive_num, array1, array2);
	}
	/**
	 * 
	 * 
	 * @param num
	 * @param arr1
	 * @param arr2
	 */
	static void mergeSort(int num, int[] arr1, int[] arr2) {
		if (num == 0) {
			int min;
			for (int i=0; i<array3.length-1; i++) {
				min = i;
				for (int j=i+1; j<array3.length; j++) {
					if (array3[j] < array3[min])
						min = j;
				}
				swap(array3, i, min);
			}
			for (int i=0; i<array3.length; i++)
				System.out.print(array3[i] + " ");
			return;
		} else if (num == 4) {	
			System.arraycopy(arr1, 0, array3, 0, arr1.length);
			mergeSort(num-1, arr1, arr2);
		} else if (num == 3){
			System.arraycopy(arr2, 0, array3, arr1.length, arr2.length);
			mergeSort(num-1, arr1, arr2);
		} else {
			mergeSort(num-1, arr1, arr2);
		}
	}
	/**
	 * index swap
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	static void swap(int[] arr, int i, int j)	 {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	

}
