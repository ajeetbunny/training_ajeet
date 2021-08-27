package invoice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InvoiceService {
	public static void Invoicedb(int quantity, float finalBill, String productName, String username) {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Storedb;create=true",
					"user", "user");
			PreparedStatement pstmt = connection.prepareStatement("insert into app.invoice values(?,?,?,?)");
			pstmt.setString(1, username);
			pstmt.setString(2, productName);
			pstmt.setInt(3, quantity);
			pstmt.setFloat(4, finalBill);
			pstmt.executeUpdate();
			System.out.println("Invoice Created");
		} catch (ClassNotFoundException | SQLException se) {
			se.printStackTrace();
		}
	}

	public static void Invoice_Display() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/storedb;create=true",
					"user", "user");
			Statement st = connection.createStatement();
			String q = "Select * from app.invoice";

			ResultSet rs = st.executeQuery(q);

			if (rs.next()) {
				System.out.println("\n");
				System.out.println("-----------------------------------------------------");
				System.out.format("%10s %10s %10s %20s", "userid", "product", "quantity", "bill_amount");
				System.out.println();
				System.out.println("-----------------------------------------------------");
				do {
					System.out.format("%10s %10s %10s %20s", rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4));
					System.out.println();
				} while (rs.next());
				System.out.println("\n");
			} else {
				System.out.println("Record Not Found...");
			}

			connection.close();

		} catch (ClassNotFoundException | SQLException ce) {
			System.out.println("Unable to display the invoice");
		}
	}

}
