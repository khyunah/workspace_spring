package deco;

public class A3 extends AudiDecorator {

	public A3(ICar audi, String modelName, int modelprice) {
		super(audi, modelName, 2_000);
	}
}
