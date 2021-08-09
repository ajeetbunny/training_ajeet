import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

 

public class Task {
    public static void main(String[] args) {
        try {
        	 Class.forName("org.apache.derby.jdbc.ClientDriver");
             Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true",
                     "user", "user");
            PreparedStatement st = connection.prepareStatement("insert into app.employee values(?,?)");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter EmpId: ");
            String empId = sc.next();
            System.out.println("Enter EmpName: ");
            String empNm = sc.next();
            st.setString(1, empId);
            st.setString(2, empNm);
            st.execute();
            connection.close();

 

        } catch (ClassNotFoundException | SQLException se) {
            se.printStackTrace();
        }

 

    }

 

}
//
//
//JDBC - Java Database connectivity
//
//1. jars - > Java want to communicate with DB it cant directly interact with it it need a medium
//jdbc client jars - oracle, mysql, postgresql, derby - sql and no sql -> client jars
//
//1, load the client drivers using class.forname
//2. drivermanager we will create connection - db url, username and password
//3. execute the statement - select insert update and delete -> CRUD operations -> create, updat, delete and retrieve
//4. process result set
//
//
//
//statement - > 
//