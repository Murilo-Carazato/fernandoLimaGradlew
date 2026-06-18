package jakarta.factory;

public class MotorDiesel implements Motor {

	@Override
	public void ligar() {
		System.out.println("Ligando o motor a diesel");
	}

	@Override
	public void desligar() {
		System.out.println("Desligando o motor a diesel");
	}

	@Override
	public void acelerar() {
		System.out.println("Acelerando o motor a diesel");
	}
	
	

}
