package adapter_1;

public class ElectronicAdapter implements IElectronic220v {

	private IElectronic110v electronic110v;
	
	public ElectronicAdapter(IElectronic110v electronic110v) {
		this.electronic110v = electronic110v;
	}
	
	@Override
	public void connect() {
		electronic110v.connect();
	}
}
