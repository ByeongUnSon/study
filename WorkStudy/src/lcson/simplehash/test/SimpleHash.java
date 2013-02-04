package lcson.simplehash.test;

public class SimpleHash {

	private int hTableSize;
	private Entry[] hTable;
	
	public SimpleHash(int hTableSize) {
		this.hTableSize = hTableSize;
		hTable = new Entry[hTableSize];		// 해시 테이블에 메모리 할당
	}
	
	public int hFunc(int value) {
		return value % hTableSize;
	}
	
	public void insert(int data) {
		int value;
		Entry entry;	
		
		entry = new Entry();
		entry.setValue(data);
		
		value = hFunc(data);	// 해시값 계산
		if (hTable[value] == null) {	// 해시값의 셀이 비어있을 경우
			hTable[value] = entry;	// 삽입
			System.out.print(data + " 입력\t");
		} else {
			System.out.print(data + " 입력 실패\t");
		}
	}
	
	public void showHashTable() {
		for (int i=0; i<hTableSize; i++) {
			if (hTable[i] == null)
				System.out.print("_ ");
			else
				System.out.print(hTable[i].getValue() + " ");
		}
		System.out.println();

	}
	
	public static void main(String[] args) {
		System.out.println("This is Simple Hash");
		
		SimpleHash sh = new SimpleHash(11);
		
		sh.insert(4);
		sh.showHashTable();
		sh.insert(8);
		sh.showHashTable();
		sh.insert(12);
		sh.showHashTable();
		sh.insert(16);
		sh.showHashTable();
		sh.insert(20);
		sh.showHashTable();
		sh.insert(24);
		sh.showHashTable();
		sh.insert(28);
		sh.showHashTable();
		sh.insert(32);
		sh.showHashTable();
		
		sh.insert(30);
	}

}
