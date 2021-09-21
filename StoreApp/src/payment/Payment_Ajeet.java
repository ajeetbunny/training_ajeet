package payment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Payment_Ajeet {
	static Scanner sc=new Scanner(System.in);
	private static String username;
	private static float bill_amount;
	public Payment_Ajeet(String username,float bill_amount){
		this.username=username;
		this.bill_amount=bill_amount;
	}
	
	public static void creditPayment() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/storedb;create=true",
					"user", "user");
			
			Statement statement = con.createStatement();
			ResultSet rs =  statement.executeQuery("select * from app.payment where userid='"+username+"'");
			rs.next();
			//String d = rs.getString(2);
			int limit = rs.getInt(2);
			PreparedStatement st = con.prepareStatement("update app.payment set credit_card=? where userid=?");
			if(limit>=bill_amount ){
				float remainingBal=limit-bill_amount;
				st.setFloat(1, remainingBal);
				st.setString(2, username);
				st.executeUpdate();
				con.commit();
				System.out.println("Bill payment approved");
			}
			else if(limit<bill_amount)
			{
				float remainingBal=limit-1000;
				st.setFloat(1, remainingBal);
				st.setString(2, username);
				st.executeUpdate();
				con.commit();
				System.out.println("The amount is higher than the available limit in your card ");
				System.out.println("Do you want to pay the rest amount? \n Please select any mode \n 1.Debit Card \n 2.Cash \n 3.Declined Transaction");
				switch(sc.next())
				{
				case "1":
					con.commit();
					Payment_Ajeet.debitPayment(username,remainingBal);
					System.out.println("Transaction Completed");
					break;
				case "2":
					con.commit();
					System.out.println("Please pay "+remainingBal+" in cash ");
					System.out.println("Transaction Completed");
					break;
				case "3":
					System.out.println("Transaction Declined");
					break;
				default:
					System.exit(0);
				}
			}
			else {
				con.rollback();
				System.out.println("Insufficient Limit try other payment option");
				System.out.println("Transaction Declined");
				System.exit(0);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Try restarting the application.");
		}
		
	}
	public static void debitPayment(String username,float bill_amount) {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/storedb;create=true",
					"user", "user");
			con.setAutoCommit(false);
			Statement statement = con.createStatement();
			ResultSet rs =  statement.executeQuery("SELECT * FROM app.payment where userid='"+username+"'");
			rs.next();
			String d = rs.getString(3);
			int limit = Integer.parseInt(d);
			float remainingBal = limit-bill_amount;
			PreparedStatement st = con.prepareStatement("update app.payment set debit_card=? where userid=?");
			st.setString(2, username);
			st.setFloat(1, remainingBal);
			st.executeUpdate();
			if(remainingBal>=0 && limit>=bill_amount ){
				con.commit();
				System.out.println("Bill payment approved");
			}
			else {
				con.rollback();
				System.out.println("Insufficient Balance");
				System.out.println("Transaction Declined");
				System.exit(4);
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Invalid Input");
		}
		
	}
}