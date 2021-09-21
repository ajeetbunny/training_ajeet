package billing;
public class BillAjeet  {
	
	
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

}
