import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class MyClass2 {
public static void main(String[] args) {
	Set<String> set=new HashSet<>();
	set.add("1");
	set.add("1");
	set.add("0");
	Iterator itr=set.iterator();
	while(itr.hasNext())
	{
		String obj=(String)itr.next();
		System.out.println(obj);
	}
}
}
