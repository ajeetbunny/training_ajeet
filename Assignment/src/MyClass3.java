import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MyClass3 {
	public static void main(String[] args) {
		Map <String,String> mp=new HashMap<>();
		mp.put("products","A");
		mp.put("product","B");
		mp.put("produc","C");
		mp.put("products","C");
		System.out.println(mp.size());
		System.out.println(mp.get("products"));
		
		Iterator itr=mp.keySet().iterator();
		while(itr.hasNext())
		{
			System.out.println(mp.get(itr.next()));
	}
	} 
}
