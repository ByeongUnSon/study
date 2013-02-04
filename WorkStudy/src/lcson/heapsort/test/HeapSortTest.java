package lcson.heapsort.test;

public class HeapSortTest {

	public static void main(String[] args) {
		HeapSort hs = new HeapSort(12);
		
		hs.insert(5);
		hs.showHeap();
		hs.insert(3);
		hs.showHeap();
		hs.insert(8);
		hs.showHeap();
		hs.insert(14);
		hs.showHeap();
		hs.insert(4);
		hs.showHeap();
		hs.insert(16);
		hs.showHeap();
		hs.insert(1);
		hs.showHeap();
		hs.insert(10);
		hs.showHeap();
		hs.insert(11);
		hs.showHeap();
		hs.insert(2);
		hs.showHeap();
		hs.insert(6);
		hs.showHeap();
		hs.insert(20);
		hs.showHeap();
		
		System.out.println();
		
		hs.delete();
		hs.showHeapSort();
		hs.delete();
		hs.showHeapSort();
		hs.delete();
		hs.showHeapSort();		
	}

}
