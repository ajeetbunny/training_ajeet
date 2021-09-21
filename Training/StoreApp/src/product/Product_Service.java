package product;
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
public class Product_Service {
	static int duplicate=0;
	public static void ImportData() throws Exception{
		try {
			BufferedReader lineReader=new  BufferedReader(new FileReader("products.csv"));
			lineReader.readLine();
			String lineText="";
			while((lineText=lineReader.readLine())!=null)
			{
				String[] data=lineText.split(",");
				try{
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Storedb;create=true",
					"user", "user");
			
			PreparedStatement pstmt=connection
					.prepareStatement("insert into app.product values(?,?,?,?,?,?,?,?)");
	                pstmt.setString(1,data[0]);
	                pstmt.setString(2,data[1]);
	                pstmt.setString(3,data[2]);
	                pstmt.setString(4,data[3]);
	                pstmt.setString(5,data[4]);
	                pstmt.setString(6,data[5]);
	                pstmt.setString(7,data[6]);
	                String x="";
	                if(data[5].equals("0"))
	                {
	                pstmt.setString(8, "Out of Stock");
	                x="In Stock";
	                }
	                else
	                {
	                	pstmt.setString(8,"In Stock");
	                	x="Out Of Stock";
	                }
	                pstmt.execute();
	                connection.close();
	                }
		 catch (ClassNotFoundException | SQLException e) {
			if(e instanceof SQLIntegrityConstraintViolationException)
			{
				duplicate++;
			}
		}
		}
		}
		catch(IOException ie)
		{
			ie.printStackTrace();
			}
		if(duplicate>0)
		{
			System.out.println(" \n Product already Imported.");
		}
		else
		{
			System.out.println("\n Imported");
			Product_Service.ShowData();
		}
		}
	
	
	public static void ShowData() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/sample;create=true",
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
				do {
					System.out.format("%5s %20s %10s %20s %20s %10s %10s %20s", rs.getString(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
							rs.getString(8));
					System.out.println();
				} while (rs.next());
				System.out.println("\n");
			} else {
				System.out.println("Record Not Found...");
			}

			connection.close();

		} catch (ClassNotFoundException | SQLException ce) {

		}
	}

}