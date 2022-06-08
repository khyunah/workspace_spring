package adapter;

public class ElectronicAdapter implements IElectronic220v {

	// adapter 패턴을 설계하는 방법 
	
	// 1. 포함관계를 만들어 준다. ( 변환시킬 대상을 110v )
	private IElectronic110v electronic110v;
	
	// 2. 생성자를 통해서 의존 주입을 받을수 있도록 설계 한다.
	// 생성자는 객체를 메모리에 올릴때 반드시 호출해야 하는 강제성이 생긴다. 
	public ElectronicAdapter(IElectronic110v electronic110v) {
		this.electronic110v = electronic110v;
	}
	
	@Override
	public void connect() {
		electronic110v.connect();
	}
}
