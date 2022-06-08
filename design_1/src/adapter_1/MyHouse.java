package adapter_1;

public class MyHouse {
	
	public static void homeConnect(IElectronic220v electronic220v) {
		electronic220v.connect();
	}

	public static void main(String[] args) {
		AirConditionner airConditionner = new AirConditionner();
		homeConnect(airConditionner);
		
		HairDryer hairDryer = new HairDryer();
		ElectronicAdapter adapter1 = new ElectronicAdapter(hairDryer);
		adapter1.connect();
		
		Cleaner cleaner = new Cleaner();
		ElectronicAdapter adapter2 = new ElectronicAdapter(cleaner);
		adapter2.connect();
	}
}
