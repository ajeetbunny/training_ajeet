package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Practice_11_Aug_21 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(new File("employee.txt")));
		
		Employee emp=new Employee();
		emp.setId(100);
		emp.setName("java");
		oos.writeObject(emp);
		oos.close();
		System.out.println("completed");
		
		ObjectInputStream ois =new ObjectInputStream(new FileInputStream(new File("employee.txt")));
		Employee obj=(Employee) ois.readObject();
		System.out.println(obj.getName()+"---"+obj.getId());
		System.out.println(emp.equals(obj));
		ois.close();
		
	}	
}
class Employee implements Serializable{ 
    /**
	 * 
	 */
	//private static final long serialVersionUID = 7692716396840342878L;
	private int id;
    private String name;
    public Employee() {
    }
    public Employee(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

 

    public int getId() {
        return id;
    }

 

    public void setId(int id) {
        this.id = id;
    }

 

    public String getName() {
        return name;
    }

 

    public void setName(String name) {
        this.name = name;
    }}
