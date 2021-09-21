import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableComparator {
	public static void main(String[] args) {
		List<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(3);
        intList.add(2);
        intList.add(5);
        intList.add(4);
        Collections.sort(intList,Collections.reverseOrder());
        System.out.println(intList);
	}

}
