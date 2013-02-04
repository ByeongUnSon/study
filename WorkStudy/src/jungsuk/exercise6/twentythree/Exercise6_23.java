package jungsuk.exercise6.twentythree;

public class Exercise6_23 {
	public static void main(String[] args) {
		int[] data = {3,2,9,4,7};
		System.out.println(java.util.Arrays.toString(data));
		System.out.println("�ִ밪:"+max(data));
		System.out.println("�ִ밪:"+max(null));
		System.out.println("�ִ밪:"+max(new int[]{})); // ũ�Ⱑ 0�� �迭
	}
	
	static int max(int[] arr) {
		int max = -999999;
		if (arr == null || arr.length == 0) {
			return max;
		}
		
		for (int i=0; i<arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

}
