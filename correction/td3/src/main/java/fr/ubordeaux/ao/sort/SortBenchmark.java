package fr.ubordeaux.ao.sort;

import java.util.HashMap;
import java.util.Map;

public class SortBenchmark {
	private Map<String, Sort> sorts = new HashMap<String, Sort>();
	
	public void addAlgorithm(String name, Sort s) {
		sorts.put(name, s);
	}
	
	public void bench(String [] unsorted) {
		for (Map.Entry<String, Sort> e : sorts.entrySet()) {
			System.out.println(e.getKey() + "**************");
			long start = System.currentTimeMillis();
			String [] sorted = e.getValue().sort(unsorted);
			System.out.println(System.currentTimeMillis() - start);
			for (String s : sorted)
				System.out.print(s + " ");
			System.out.println();
		}
	}
	
	public static void main(String [] args) {
		SortBenchmark sb = new SortBenchmark();
		sb.addAlgorithm("Bubble", BubbleSort.BUBBLE_SORT);
		sb.addAlgorithm("Insertion", InsertionSort.INSERTION_SORT);
		System.out.println();
		sb.bench(args);
	}
}
