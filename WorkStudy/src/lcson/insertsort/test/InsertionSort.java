package lcson.insertsort.test;

/**
 * �������ĺ��� ���� 2�� ������ ���� ���ĺ��ٵ� �ణ ������.
 * 
 * �̹� ��� ���� ���ĵ� �迭���� ���� ū ȿ���� ����.
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
		for (int i=1; i<arr.length; i++) {	// ���� ������ �׸� ����
			int tmp = arr[i];	// ���� ������ �׸� ����
			int j = i;		// ������ �׸� ��ġ�������� �� (������ -> ����)
			
			while (j>0 && arr[j-1] >= tmp) {
				// ������ �׸񺸴� ���� ���� �׸��� ã�� �� ���� ��
				arr[j] = arr[j-1];
				// ������ �׸񺸴� ū ���� ���������� �̵�
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
