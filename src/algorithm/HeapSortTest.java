package algorithm;

public class HeapSortTest {
	public static Integer[] heap = new Integer[] { 1, 3, 7, 5, 2, 8, 4, 6, 10, 9 };
	//public static Integer[] heap = new Integer[] { 1,2 };

	public static void adjustHeap(Comparable[] a,int location, int unSortlength) {
		int tempLoc = (location + 1) * 2;
		if (tempLoc < unSortlength) {
			
			if (a[tempLoc - 1].compareTo(a[tempLoc]) <=0) {
				
				if (a[location].compareTo(a[tempLoc]) < 0) {
					
					//if(tempLoc == 9){System.out.println(9);}
						swap(a,location,tempLoc);
					
					adjustHeap(a,tempLoc, unSortlength);
				}
			} else {
				if (a[location].compareTo(a[tempLoc - 1]) < 0) {
					
					swap(a,location,tempLoc - 1);
					
					adjustHeap(a,tempLoc - 1, unSortlength);
				}
			}
		}
		else if ((tempLoc = (location + 1) * 2 - 1) < unSortlength) {
			if (a[location].compareTo(a[tempLoc]) < 0) {
				swap(a,location,tempLoc);
				
				adjustHeap(a,tempLoc, unSortlength);
			}
		}
	}

	private static void swap(Comparable[] a,int i,int j){
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
		return;
	}
	
	public static void createHeap(Comparable[] a,int length) {
		for (int i = length - 1; i >= 0; i--) {
			adjustHeap(a,i, length);
		}
	}
	
	public void heapSort(Comparable[] a){
		createHeap(a,a.length);
		for(int i = a.length - 1; i > 0; i --){
			swap(a,0,i);
			adjustHeap(a,0,i);
		}
	}
	
	public static void main(String[] args) {
		createHeap(heap,heap.length);
		
		for (int j = 0; j < heap.length; j++) {
			System.out.print(heap[j] + " ");
		}
		System.out.println();
		
		for (int i = heap.length - 1; i > 0; i--) {
			swap(heap,0,i);
			
			for (int j = 0; j < heap.length; j++) {
				System.out.print(heap[j] + " ");
			}
			System.out.println();
			
			adjustHeap(heap,0, i);
			
			
		}
	}
}