package adapter_1;

public class AirConditionner implements IElectronic220v {

	@Override
	public void connect() {
		System.out.println("에어컨 연결 220v On");
	}
}
