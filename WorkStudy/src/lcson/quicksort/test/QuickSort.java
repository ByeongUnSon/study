package lcson.quicksort.test;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] array = new int[10];		
		
		array[0] = 1;
		array[1] = 11;
		array[2] = 88;
		array[3] = 55;
		array[4] = 99;
		array[5] = 77;
		array[6] = 66;
		array[7] = 44;
		array[8] = 22;
		array[9] = 33;
		
		displayArray(array);
		System.out.println();
		
		quickSort(array, 0, array.length - 1);
		for (int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");		// ���� �� �迭 ���
		}
		System.out.println();		
	}
	
	public static void quickSort(int[] a, int leftmost, int rightmost) {
		if (rightmost - leftmost <= 0)	// �迭�� ũ�Ⱑ 1�����̸� ����
			return;
		else {							// �迭�� ũ�Ⱑ 2�̻��� �� ������ ���� 
			int pivot = a[rightmost];
			
			int i = leftmost - 1;
			int j = rightmost;
			
			while (true) {
				
				while (a[++i] < pivot); // ���ʿ������� �Ǻ� ������ ū �� Ž��
				
				while (j > leftmost && a[--j] > pivot); // �����ʿ������� �Ǻ� ������ ���� �� Ž��
				
				if (i >= j)		// ���ʰ� ������ ��ġ�� ũ�ν� �Ǹ� ����
					break;
				
				else			// ũ�ν� ���� ������ �׸񳢸� ġȯ
					swap(a, i, j);		
			}
			swap(a, i, rightmost);	// ���ʿ��� Ž���� ū ���� �Ǻ��� ġȯ
			
			quickSort(a, leftmost, i - 1);	// ��������� �� ���� �˰��� ��ȣ��
			
			quickSort(a, leftmost + 1, rightmost);	// ��������� �� ���� �˰��� ��ȣ��
		}
	}
	
	static void swap(int[] a, int i, int j) {		// ġȯ
		int temp;
		temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	static void displayArray(int[] arr) {			// �迭�� �׸� ���
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	

}
