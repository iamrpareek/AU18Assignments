//DateSortQuest

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class DateSortQuest {
	//@SuppressWarnings("deprecation")
	public static void main(String[] args) {
        
		List<Date> myList = new ArrayList<Date>();
        myList.add(new Date(2017-1900, 8, 23));
        myList.add(new Date(2017-1900, 8, 24));
        myList.add(new Date(2016-1900, 05, 07));
        myList.add(new Date(2015-1900, 10, 13));
        myList.add(new Date(2014-1900, 07, 16));
         
        Collections.sort(myList, new Comparator<Date>(){
 
            @Override
            public int compare(Date o1, Date o2) {
                return o1.compareTo(o2);
            }
        });
         
        for(int i = 0; i < myList.size(); i++){
            System.out.println(myList.get(i).toString());
        }
 
    }

}
