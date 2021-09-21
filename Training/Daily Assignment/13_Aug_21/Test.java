import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Test {
   public static void main(String[] args) throws Exception {
        List<Employee> empLst = new ArrayList<>();
        empLst.add(new Employee(1, "java"));
        empLst.add(new Employee(5, "dotnet"));
        empLst.add(new Employee(3, "android"));
        empLst.add(new Employee(2, "python"));
        empLst.add(new Employee(4, "c"));
        System.out.println("before");
        System.out.println(empLst);
        Collections.sort(empLst, new EmployeeNameComparator());
        System.out.println("after");
        System.out.println(empLst);
    }
}