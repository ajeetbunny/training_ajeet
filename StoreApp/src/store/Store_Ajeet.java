package store;
import java.util.Scanner;

import billing.Bill_Ajeet;
import invoice.InvoiceService;
import payment.Payment_Ajeet;
import exception.MyException;

public class Store_Ajeet {
	static String reguser;
	public Store_Ajeet(String reguser){
		this.reguser = reguser;
	}
	public static void Store() throws MyException {
		
		String productTypes[] = { "Jeans", "shoes", "shirts" };
		String products[] = { "A", "B", "C" };
		float amount[] = { 100, 200, 300 };
		int quantity[] = { 1, 2, 3 };
		System.out.println("Hi There, Welcome to Clothing Store");
		System.out.println("please select clothing for M/W: ");
		Scanner sc = new Scanner(System.in);
		switch (sc.next().toLowerCase()) {
		case "m":
			System.out.println("******Displaying Men Clothing*******");
			break;
		case "w":
			System.out.println("******Displaying Women Clothing*****");
			break;
		default:
			throw new MyException("Invalid Selection");
		}
		for (int i = 0; i < productTypes.length; i++) {
			System.out.printf("%1$s %2$10s %3$s %4$" + (22 - productTypes[i].length()) + "s%n", "*", i + 1,
					productTypes[i], "*");
		}
		System.out.printf("%1$s %2$5s %3$4s%n", "*", "Please choose clothing type: ", "*");
		System.out.println("************************************");
		switch (sc.next()) {
		case "1":
		case "2":
		case "3":
			System.out.println("----------------------------");
			System.out.println("products  quantity  Amount ");
			System.out.println("----------------------------");
			for (int i = 0; i < products.length; i++) {
				System.out.printf("%1$4s %2$10s %3$10.2f%n", products[i], quantity[i], amount[i]);
			}
			System.out.println("----------------------------");
			System.out.println("select product:");
			String product = sc.next();
			System.out.println("select quantity:");
			int quant = sc.nextInt();
			int index = 0;
			switch (product.toLowerCase()) {
			case "a":
				index = 0;
				break;
			case "b":
				index = 1;
				break;
			case "c":
				index = 2;
				break;
			default:
				throw new MyException("Invalid product type");
			}
			int originalQuant = quantity[index];
			if (quant > originalQuant) {
				System.err.println("qunatity is not valid");
				System.exit(3);
			}else {
				
					System.out.println("*****Invoice generated******");
					System.out.println("----------------------------");
					System.out.println("products  quantity  Bill ");
					System.out.println("----------------------------");
					Bill_Ajeet bill = new Bill_Ajeet();
					float originalBill = bill.calculateBill(quant, amount[index]);
					int gst = 0;
					if (originalBill > 100 && originalBill <= 200) {
						gst = 10;
					} else if (originalBill > 200 && originalBill <= 500) {
						gst = 20;
					} else if (originalBill > 500) {
						gst = 30;
					}
					float finalBill = bill.calculateBill(quant, amount[index], gst);
					System.out.printf("%1$4s %2$10s %3$10.2f%n", products[index], quant, originalBill);
					System.out.println("----------------------------");
					System.out.println("Total: " + finalBill + " (" + originalBill + "Rs + " + gst + "% GST i.e. "
							+ bill.calculateGst(originalBill, gst)+"Rs)");
					float z=bill.calculateGst(originalBill, gst);
					Payment_Ajeet p=new Payment_Ajeet(reguser,finalBill);
					Payment_Ajeet payment=new Payment_Ajeet(reguser,finalBill);
					System.out.println("Please choose the payment option \n 1.Credit Card\n 2.Debit Card\n 3.Cash\n 4.Cancel Payment");
					switch (sc.next()){
						case "1":
							Payment_Ajeet.creditPayment();
							break;
						case "2":
							Payment_Ajeet.debitPayment(reguser,finalBill);
							break;
						case "3":
							System.out.println("Transaction completed through cash");
							break;
						case "4":
							System.out.println("Payment Cancelled");
							break;
						default:
							System.err.println("Invalid Input");
						}
					System.out.println("Do you want to print invoice Y/N");
					String invoice=sc.next();
					if(invoice.toLowerCase().equals("y"))
					{
						
						InvoiceService.Invoicedb(quant,finalBill,products[index],reguser);
						InvoiceService.Invoice_Display();
						Bill_Ajeet.Invoice(quant,originalBill,finalBill,gst,z,products[index]);
						
					}
					else
						System.exit(0);				
				}
				
			break;
		default:
			System.exit(2);
			System.err.println("Invalid input");
			break;
		}
		sc.close();
	}
}
