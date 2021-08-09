import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyClass{

	public static void main(String[] args) {
		List list=new ArrayList<>();
		list.add("Hello");
		list.add(2.5f);
		list.add(50);
		list.add(true);
		System.out.println(list.size());
		list.add(567);
		System.out.println(list.size());
		System.out.println(list.add(456));
		System.out.println(list.remove(0));
		System.out.println(list);
		System.out.println("----------------------");
		Set set=new  HashSet();
		set.add(5);
		set.add(4);
		set.add(1);
		set.add(0);
		set.add(1);
		set.add(2);
		set.add(4);
		System.out.println(set);
		
	}
}
