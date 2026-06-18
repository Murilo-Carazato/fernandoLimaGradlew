package jakarta.factory;

public class MotorFactory {

	public static Motor getMotor(String combustivel) {
		if (combustivel.equals("gasolina")) {
			return new MotorGasolina();
		} else if (combustivel.equals("diesel")) {
			return new MotorDiesel();
		} else if (combustivel.equals("eletrecidade")) {
			return new MotorEletrico();
		} else {
			throw new IllegalArgumentException("Motor nao existe!");
		}
	}
}
