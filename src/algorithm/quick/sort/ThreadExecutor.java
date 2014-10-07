package algorithm.quick.sort;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExecutor {
	public static ExecutorService exec = Executors.newCachedThreadPool();
	private int[] array;

	public ThreadExecutor(int[] array) {
		this.array = array;
		createThread(0, array.length - 1);
	}

	public void createThread(int start, int end) {
		Future<Point> future = exec.submit((new QuickSort(start, end, array)));
		try {
			System.out.println(future.get().getMiddle());
			if (future.get().compareStartMiddle())
				createThread(future.get().getStart(),future.get().getMiddle() - 1);
			if (future.get().compareMiddleEnd())
				createThread(future.get().getMiddle() + 1, future.get().getEnd());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void print() {
		for (int g : array)
			System.out.print(g + " ");
	}

	public static void main(String[] args) {
		int[] array = { 10, 9, 8, 7, 5, 6, 4, 3, 2, 1 };
		ThreadExecutor tx = new ThreadExecutor(array);
		tx.print();
	}
}