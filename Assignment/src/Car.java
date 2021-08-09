class Car{
	int gears;
	int brakes;
	void run(int gears,int brakes){
		System.out.println("Car is running");
	}	
}
class Maruti extends Car{
	int speed;
	public static void main(String[] args) {
		Maruti m=new Maruti();
		m.run(4, 3);		
	}
}
