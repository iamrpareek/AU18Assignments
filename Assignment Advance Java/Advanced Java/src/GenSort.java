import java.util.Arrays;

public class GenSort {
	public <E extends Comparable<E>> void selectionSort(E[] a) 
	{
	        for (int i = 0; i < a.length - 1; i++)
	        {
	            int smallest = i;
	            for (int j = i + 1; j < a.length; j++) 
	            {
	                if (a[j].compareTo(a[smallest])<=0) 
	                {
	                    smallest = j;
	                }
	            }
	            swap(a, i, smallest);
	        }
	    }

	private <E> void swap(E[] a, int i, int j) 
	{
        if (i != j) 
        {
            E temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

	public static void main(String[] args)
	{
		GenSort obj = new GenSort();
		Integer[] a = {5,12,2,72,55};
		System.out.println("Array: "+ Arrays.toString(a));
		obj.selectionSort(a);
		System.out.println("Sorted Array: "+Arrays.toString(a));
	    Character[] a1= {'r','a','h','u','l'};
	    System.out.println("Array 2: "+ Arrays.toString(a1));
	    obj.selectionSort(a1);
	    System.out.println("Sorted Array2: "+Arrays.toString(a1));
	}
}