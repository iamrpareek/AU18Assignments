import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StreamQuest 
{
	private static final String[] tens = {""," ten"," twenty"," thirty"," forty"," fifty"," sixty"," seventy"," eighty"," ninety"};
	private static final String[] units = {""," one"," two"," three"," four"," five"," six"," seven"," eight"," nine"," ten"," eleven"," twelve"," thirteen"," fourteen"," fifteen"," sixteen"," seventeen"," eighteen"," nineteen"};

	private static String convertDigitToWord(int n) 
	{
		String s;
		if (n % 100 < 20)
		{
			s = units[n%100];
			n/= 100;
		}
		else
		{
			s = units[n%10];
			n/= 10;
			s = tens[n%10] + s;
			n/= 10;
		}
		if (n==0)
			return s;
		return units[n] + " hundred" + s;
	}

	public static void main(String[] args) 
	{
		System.out.print("Insert numbers and type in a letter to end:\n");
		Scanner read = new Scanner(System.in);
		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		while (read.hasNextInt())
			arr1.add(read.nextInt());
		read.close();
		System.out.println(arr1);
		List<Integer> fMul =arr1.stream().filter(x->x%5==0).collect(Collectors.toList());
		System.out.println(fMul);
		for(int i=0;i<fMul.size();i++)
			System.out.println(convertDigitToWord(fMul.get(i)));
	}
}