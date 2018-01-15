@FunctionalInterface  
interface iFace{  
    String val(int n);  
}  

public class Lambda {
	
	public static void main(String[] args) {  
		String[] tens = {""," ten"," twenty"," thirty"," forty"," fifty"," sixty"," seventy"," eighty"," ninety"};
		String[] units = {""," one"," two"," three"," four"," five"," six"," seven"," eight"," nine"," ten"," eleven"," twelve"," thirteen"," fourteen"," fifteen"," sixteen"," seventeen"," eighteen"," nineteen"};
        iFace person = (n)-> 
        {  
        	String s;
		    if (n%100 < 20){
		      s=units[n%100];
		      n/=100;
		    }
		    else {
		      s=units[n % 10];
		      n/=10;
		      s=tens[n % 10]+s;
		      n/=10;
		    }
		    if (n==0) return s;
		    return units[n]+" hundred"+s;
		};
		System.out.println(person.val(107));  
    }

}