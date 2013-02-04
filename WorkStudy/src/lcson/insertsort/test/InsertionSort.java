package lcson.insertsort.test;

/**
 * 버블정렬보다 거의 2배 빠르며 선택 정렬보다도 약간 빠르다.
 * 
 * 이미 어느 정도 정렬된 배열에서 아주 큰 효과를 낸다.
 * 
 * @author Administrator
 *
 */
public class InsertionSort {
	
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
		insertionSort(array);
		
	}
	
	static int[] insertionSort(int[] arr) {
		for (int i=1; i<arr.length; i++) {	// 삽입 정렬할 항목 선택
			int tmp = arr[i];	// 삽입 정렬할 항목 저장
			int j = i;		// 삽입할 항목 위치에서부터 비교 (오른쪽 -> 왼쪽)
			
			while (j>0 && arr[j-1] >= tmp) {
				// 삽입할 항목보다 작은 값의 항목을 찾을 때 까지 비교
				arr[j] = arr[j-1];
				// 삽입할 항목보다 큰 값은 오른쪽으로 이동
				--j;
			}
			arr[j] = tmp;
			System.out.print("STEP " + i + " : ");
			displayArray(arr);
			System.out.println();
		}
		return arr;
	}
	
	static void displayArray(int[] arr) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
