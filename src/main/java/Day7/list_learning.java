package Day7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class list_learning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				
		List<String> arrlist= new ArrayList<String>();
		
		arrlist.add("Mangoes");
		arrlist.add("Apple");
		arrlist.add("Chickoo");
		arrlist.add("banana");
		arrlist.add("Mangoes");
		
		//for each
//		for(String x:arrlist)
//		{
//			System.out.println(x);
//			
//		}
//		
		
		//for loop
//		for(int i=0;i<arrlist.size();i++)
//		{
//			System.out.println(arrlist.get(i));
//			
//		}
		
		//Iterator
		
		Iterator<String> itr = arrlist.iterator();
		
		while(itr.hasNext())
		{
			System.out.println(itr.next());
			
		}
		

	}

}
