package billing;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Bill_Ajeet {
	public float calculateBill(float quantity,float price) {
		return quantity*price;
	}
	public float calculateBill(float quantity,float price,int gst) {
		float amount = calculateBill(quantity, price);
		return amount+=(amount*gst/100);
	}
	
	public float calculateGst(float amount,int gst) {		
		return (amount*gst/100);
	}
public static void Invoice(int b,float originalBill,float finalBill,int gst,float z, String productName){
	Scanner sc=new Scanner(System.in);
		try{
			PrintStream f=new PrintStream("myInvoice.txt");
			System.setOut(f);
			f.println("*****Invoice generated******");
			f.println("----------------------------");
			f.println("products  quantity  Bill ");
			f.println("----------------------------");
			f.printf("%1$4s %2$10s %3$10.2f%n", productName, b, originalBill);
			f.println("----------------------------");
			f.println("Total: " + finalBill + " (" + originalBill + "Rs + " + gst + "% GST i.e. "
							+ z+"Rs)");						
			f.close();	
			System.out.println("Invoice Printed");
			
			
		}
		catch (IOException io)
		{
			System.out.println("Unable to generate the invoice");
		}
		
	}


}
