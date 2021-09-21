package product;
import java.io.IOException;
import java.util.Scanner;

public class ProductServiceClass {
	Scanner sc=new Scanner(System.in);
	public void productService() throws NumberFormatException, IOException{
		System.out.println("1. import product data\n 2. check product data \n 3. check invoice");
		switch(sc.nextInt()){
		case 1:
		{
			ProductService.ImportData();
			ProductService.ShowData();
			break;
		}
		case 2:
		{
			ProductService.ShowData();
			break;
		}
		case 3:
		{
			System.out.println("Display invoice");
			break;
		}
		default:
			System.out.println();
		}
		
	}

}
