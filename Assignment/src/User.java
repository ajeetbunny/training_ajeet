import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User  {
	Scanner sc=new Scanner(System.in);
	Map<String,String> mp=new HashMap<>();
	
//public static void main(String[] args) {
	public void UserR(){	
		User u=new User();
		System.out.println("Hi \n 1. Login \n 2. Register");
			switch(sc.nextInt())
			{
			case 1:
				
				u.login();
				break;
			case 2:
				u.register();
				break;
			default:
				System.out.println("Invalid Value");
			}
		}
		public void register(){
			System.out.println("userName");
			String sample=sc.nextLine();
			String reguser=sc.nextLine();
			System.out.println("password");
			String regpass=sc.nextLine();
			if(mp.containsKey(reguser)==false)
			{
				mp.put(reguser, regpass);
				User u2=new User();
				System.out.println("Please Select the User Role \n 1. Admin \n 2. Manager \n 3.User");
				switch(sc.nextInt())
				{
				case 1:
					System.out.println(reguser+" Created as Admin");
					u2.UserR();
					break;
				case 2:
					
					System.out.println(reguser+" Created as Manager");
					u2.UserR();
					break;
				case 3:
					System.out.println(reguser+" Created as User");
					u2.UserR();
					break;
				default:
					System.out.println("Invalid User Type");
					
				}
				
			}
			else
				System.out.println("Username already available");
		}
		public void login(){
			System.out.println("userName");
			//String sample2=sc.nextLine();
			String reguser=sc.nextLine();
			System.out.println("password");
			String regpass=sc.nextLine();
			if(mp.containsKey(reguser))
			{
				if(regpass.equals(mp.get(reguser)))
				{
					System.out.println("User Logged IN \n");
					StoreAjeet app=new StoreAjeet();
					app.Store();
				}
				else
					System.out.println("Invalid Password");
			}
			else
				System.out.println("Invalid Username or Password");
			
		}
}

