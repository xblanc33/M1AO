package fr.ubordeaux.ao.sort;

public class InsertionSort implements Sort {
	public static final Sort INSERTION_SORT = new InsertionSort();

	@Override
	public String[] sort(String[] unsorted) {
		String [] sorted = unsorted.clone();
		for (int i = 1; i < sorted.length; i++) {
			String x = sorted[i];
			int j = i;
			while (j > 0 && sorted[j-1].compareTo(x) > 0) {
				sorted[j] = sorted[j-1];
				j--;
			}
			sorted[j] = x;
		}
		return sorted;
	}
}
