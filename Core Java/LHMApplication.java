
public class LHMApplication {
	     
	    public static void main(String[] args) {
	           LinkedHM<Integer, Integer> linkedHashMap = new LinkedHM<Integer, Integer>();
	 
	           linkedHashMap.put(23, 12);
	           linkedHashMap.put(25, 121);
	           linkedHashMap.put(41, 151);
	           linkedHashMap.put(32, 15);
	           linkedHashMap.put(39, 89);
	 
	           System.out.println("Values for keys>");
	           System.out.println("Key 41=" + linkedHashMap.get(41));
	           System.out.println("Key 23=" + linkedHashMap.get(23));
	 
	           System.out.print("Linked Hash Map: ");
	           linkedHashMap.display();
	 
	           System.out.println("Value for key 23 removed: " + linkedHashMap.remove(23));
	           System.out.println("Value for key 51 removed: " + linkedHashMap.remove(51));
	 
	           System.out.print("Displaying: ");
	           linkedHashMap.display();
	 
	    }
}
