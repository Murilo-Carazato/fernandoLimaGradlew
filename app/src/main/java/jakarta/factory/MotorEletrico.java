package jakarta.factory;

public class MotorEletrico implements Motor {

	@Override
	public void ligar() {
		System.out.println("Ligando o motor eletrico");
	}

	@Override
	public void desligar() {
		System.out.println("Desligando o motor eletrico");
	}

	@Override
	public void acelerar() {
		System.out.println("Acelerando o motor eletrico");
	}
	
	

}
