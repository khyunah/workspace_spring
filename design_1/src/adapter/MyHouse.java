package adapter;

public class MyHouse {

	// 집에 전기 콘센트에 연결하는 동작 
	public static void homeConnect(IElectronic220v electronic220v) {
		electronic220v.connect();
	}
	
	public static void main(String[] args) {
		// 1. 에어컨
		// 2. 헤어드라이기
		// 3. 청소기 
		
		// 추상화를 해달라 ㅡ> 인터페이스를 만들어 달라 ㅡ> 공통적인 것을 추상
		// 사용하려면 전기가 필요하기 때문에 연결하는 동작 구현하기 
		
		// 문제 인식
		// 친구가 일본에서 결혼 선물로 청소기, 헤어드라이기를 선물해줬다.
		// 선물해준 것은 110v 로 동작을 한다.
		// 집에 있는 에어컨은 220v 로 동작을 한다. 
		
		// 사용하기
		AirConditionner airConditionner = new AirConditionner();
		// 콘센트에 연결해보기 
		homeConnect(airConditionner);
		
		HairDryer hairDryer = new HairDryer();
//		homeConnect(hairDryer);
		
		Cleaner cleaner = new Cleaner();
//		homeConnect(cleaner);
		
		// 어댑터를 구매해서 사용하기
		ElectronicAdapter adapter1 = new ElectronicAdapter(hairDryer);
		
		// 집에있는 콘센트에 연결하기 
		homeConnect(adapter1);
		
		ElectronicAdapter adapter2 = new ElectronicAdapter(cleaner);
		homeConnect(adapter2);
	}
}
