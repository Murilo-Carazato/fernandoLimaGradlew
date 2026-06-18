package jakarta.factory;

public class Principal {
	
	public static void main(String[] args) {
		Motor m = MotorFactory.getMotor("etanol");
		m.ligar();
		m.acelerar();
		m.desligar();
	}

}
