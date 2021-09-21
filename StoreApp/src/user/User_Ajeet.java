package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import exception.MyException;
import invoice.InvoiceService;
import product.Product_Service;
import store.Store_Ajeet;

public class User_Ajeet {

	static Scanner sc = new Scanner(System.in);
	Map<String, String> mp = new HashMap<>();
	static User_Ajeet u = new User_Ajeet();
	static String Role = null;
	static String reguser = null;
	static String regpass = null;
	// static Map<String ,User_Ajeet> user_Add=new HashMap<>();

	public static void main(String[] args) throws Exception {
		System.out.println("Hi \n 1. Login \n 2. Register");
		switch (sc.nextInt()) {
		case 1:
			u.login();
			break;
		case 2:
			u.register();
			break;
		default:
			throw new MyException("Invalid value");
		}
	}

	public void register() throws Exception {
		sc.nextLine();
		System.out.println("Please enter the Username");
		reguser = sc.nextLine();
		System.out.println("Please enter the Password");
		regpass = sc.nextLine();
		if (mp.containsKey(reguser) == false) {
			mp.put(reguser, regpass);
			User_Ajeet.add();
			System.out.println("Please Select the User Role \n 1. Admin \n 2. Manager \n 3.User");
			switch (sc.nextInt()) {
			case 1:
				System.out.println(reguser + " Created as Admin");
				Role = "Admin";
				break;
			case 2:
				System.out.println(reguser + " Created as Manager");
				Role = "Manager";
				break;
			case 3:
				System.out.println(reguser + " Created as User");
				Role = "User";
				break;
			default:
				throw new MyException("Invalid user type");
			}

			System.out.println("Hi \n 1. Login \n 2. Register");
			switch (sc.nextInt()) {
			case 1:
				u.login();
				break;
			case 2:
				u.register();
				break;
			default:
				throw new MyException("Invalid selection");
			}
		} else
			System.out.println("Username already available");
	}

	public void login() throws Exception {
		sc.nextLine();
		System.out.println("Please Enter the User Name");
		reguser = sc.nextLine();
		System.out.println("Please Enter the Password");
		regpass = sc.nextLine();
		if (mp.containsKey(reguser)) {
			if (regpass.equals(mp.get(reguser)) && Role == "Admin") {
				System.out.println("Admin Logged In \n");
				System.out.println("1.import product data\n 2. check product data \n 3. check invoice");
				switch (sc.nextInt()) {
				case 1: {
					Product_Service.ImportData();
					break;
				}
				case 2: {
					Product_Service.ShowData();
					break;
				}
				case 3: {
					InvoiceService.Invoice_Display();
					break;
				}
				default:
					System.err.println("Invalid Input");
				}
			} else if (regpass.equals(mp.get(reguser))) {
				System.out.println(Role + " Logged IN \n");
				Store_Ajeet app = new Store_Ajeet(reguser);
				Store_Ajeet.Store();

			} else
				System.out.println("Invalid Password");
		} else
			System.out.println("Invalid Username or Password");
	}

	public static void add() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			Connection connection = DriverManager.getConnection("jdbc:derby://localhost:1527/Storedb;create=true",
					"user", "user");
			connection.setAutoCommit(false);
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("SELECT * FROM app.payment where userid='" + reguser + "'");
			String d = "";
			if (rs.next() == false) {
				PreparedStatement st = connection.prepareStatement("insert into app.payment values(?,?,?)");
				st.setString(1, reguser);
				st.setInt(2, 1000);
				st.setInt(3, 1000);
				st.execute();
			} else {
				d = rs.getString(1);
			}

			if (d.equals(reguser)) {
				connection.rollback();
			} else {
				connection.commit();
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
