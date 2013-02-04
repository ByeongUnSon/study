package jungsuk.exercise11.ten;

import java.util.*;

public class Exercise11_10 {
	
	public static void main(String[] args) {
		Set<Object> set = new HashSet<Object>();
		int[][] board = new int[5][5];
		
		while (set.size() < 25) {
			set.add((int) (Math.random() * 30) + 1 + "");
		}
		ArrayList<Object> list = new ArrayList<Object>(set);
		Collections.shuffle(list);
		//Iterator<Object> it = set.iterator();
		Iterator<Object> it = list.iterator();
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = Integer.parseInt((String) it.next());
				System.out.print((board[i][j] < 10 ? " " : " ") + board[i][j]);
			}
			System.out.println();
		}
	} // main
}