package jakarta.factory;

public class MotorGasolina implements Motor {

	@Override
	public void ligar() {
		System.out.println("Ligando o motor a gasolina");
	}

	@Override
	public void desligar() {
		System.out.println("Desligando o motor a gasolina");
	}

	@Override
	public void acelerar() {
		System.out.println("Acelerando o motor a gasolina");
	}
	
	

}
