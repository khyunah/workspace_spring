package deco;

public class AudiDecorator implements ICar {
	
	protected ICar audi;
	protected String modelName;
	protected int modelPrice;

	public AudiDecorator(ICar audi, String modelName, int modelprice) {
		this.audi = audi;
		this.modelName = modelName;
		this.modelPrice = modelprice;
	}
	
	@Override
	public int getPrice() {
		return audi.getPrice() + modelPrice;
	}

	@Override
	public void showPrice() {
		System.out.println(modelName + " 의 가격은 " + getPrice() + " 만원 입니다.");
	}
}
