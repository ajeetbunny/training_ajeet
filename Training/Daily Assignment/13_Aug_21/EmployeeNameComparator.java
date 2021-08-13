import java.util.Comparator;
public class EmployeeNameComparator implements Comparator<Employee> {

	@Override
    public int compare(Employee o1, Employee o2) {
        return o1.getEmpNm().compareTo(o2.getEmpNm());
    }

 

}
 

