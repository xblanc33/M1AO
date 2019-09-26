package fr.ubordeaux.ao.sort;


public class BubbleSort implements Sort {

	public static final Sort BUBBLE_SORT = new BubbleSort();
	
	@Override
	public String[] sort(String[] unsorted) {
		String [] sorted = unsorted.clone();
		for (int i = sorted.length - 1; i > 0; i--) 
			for (int j = 0; j < i; j++)
				if (sorted[j+1].compareTo(sorted[j]) < 0) {
					String s = sorted[j];
					sorted[j] = sorted[j+1];
					sorted[j+1] = s;
				}
		return sorted;
	}
	
	

}
