package tddfema;

import org.junit.Assert;
import org.junit.Test;

public class TesteCalculadora {

	@Test
	public void testar() {
		int a = 2;
		int b = 2;
		int esperado = 4;
		int resultado;
		Calculadora calc = new Calculadora();
		resultado = calc.somar(a, b);
		Assert.assertEquals(esperado, resultado);
	}

}
