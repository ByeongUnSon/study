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
		int h = 1;		// h ���� 1�� ����
		
		while (h <= arr.length / 3) {
			h = h * 3 + 1;				// h ���� ũ���� ���ݼ����� �����Ͽ� ã�´�.
		}
		
		while (h > 0) {		// ���� ���� �˰���� ������ ���
			for (int i=h; i<arr.length; i++) {	// ���� ������ �׸� ����
				int tmp = arr[i];
				int j = i;
				
				while (j>h-1 && arr[j-h] >= tmp) {
					
					// ������ �׸񺸴� ���� ���� �׸��� ã�� �� ���� ��
					// ���� �迭������ �� ��, 0, 4, 8
					
					arr[j] = arr[j-h];	// ������ �׸񺸴� ū ���� ���������� �̵�
					
					j -= h;
				}
				arr[j] = tmp;
				displayArray(arr);
				System.out.println();
			}
			h = (h-1) / 3;		// h���� ���δ�.
		}
		return arr;
	}
	
	static void displayArray(int[] arr) {	
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
