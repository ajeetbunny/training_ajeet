import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import static java.lang.Integer.parseInt;
public class ProductService {
	public static void ImportData() throws NumberFormatException, IOException{
		int batchSize=20;
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true",
					"user", "user");
			BufferedReader lineReader=new  BufferedReader(new FileReader("products.csv"));
			//Statement st = connection.createStatement();
			//st.executeUpdate("create table app.product (id INT NOT NULL ,name varchar(100),gender varchar(100), brand varchar(100),category varchar(100),quantity INT,price INT,"
				//	+ "status varchar(100), PRIMARY KEY(id))");
			PreparedStatement pstmt=connection
					.prepareStatement("insert into app.product values(?,?,?,?,?,?,?)");
			
			String lineText=null;
			int count =0;
			lineReader.readLine();
			while((lineText=lineReader.readLine())!=null)
			{
				String[] data=lineText.split(",");
				 String id=data[0];
	                String name=data[1];
	                String gender=data[2];
	                String brand=data[3];
	                String category=data[4];
	                String quantity=data[5];
	                String price=data[6];
	                pstmt.setInt(1,parseInt(id));
	                pstmt.setString(2,name);
	                pstmt.setString(3,gender);
	                pstmt.setString(4,brand);
	                pstmt.setString(5,category);
	                pstmt.setInt(6,parseInt(quantity));
	                //pstmt.setInt(7,parseInt(price));
	                //pstmt.setString(8, "Stock");
	                pstmt.addBatch();
	                if(count%batchSize==0){
	                    pstmt.executeBatch();
	                }
	            }
	                //String Status = " ";
					

	            lineReader.close();
	            pstmt.executeBatch();
	            connection.commit();
	           connection.close();
	            System.out.println("Data has been inserted successfully.");
	            ProductService.ShowData();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}

		}
	

		
		
		
	
	
	
	
	
	public static void ShowData() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/ProductDb;create=true",
					"user", "user");
			Statement st = connection.createStatement();
			String q = "Select * from app.product";
			ResultSet rs = st.executeQuery(q);

			if (rs.next()) {
				System.out.println("\n");
				System.out.println(
						"--------------------------------------------------------------------------------------------------------------------------");
				System.out.format("%5s %20s %10s %20s %20s %10s %10s %20s", "id", "name", "gender", "brand", "category",
						"quantity", "price", "status");
				System.out.println(
						"\n--------------------------------------------------------------------------------------------------------------------------");
				
					System.out.format("%5s %20s %10s %20s %20s %10s %10s %20s", rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
							rs.getString(8));
					System.out.println();
				 while (rs.next());
				System.out.println("\n");
			} else {
				System.out.println("Record Not Found...");
			}

			connection.close();

		} catch (ClassNotFoundException | SQLException ce) {

		}
	}

}

