package tddfema;

public class Impostos {
	
	public int calcularIcms(int valorOperacao, int aliquota) {
		return (valorOperacao * aliquota) / 100;
	}

}
