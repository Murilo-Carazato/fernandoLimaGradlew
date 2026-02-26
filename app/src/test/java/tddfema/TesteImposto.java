package tddfema;

import org.junit.Assert;
import org.junit.Test;

public class TesteImposto {

	@Test
	public void testar() {
		int a = 1000;
		int b = 18;
		int esperado = 180;
		int resultado;
		Impostos calc = new Impostos();
		resultado = calc.calcularIcms(a, b);
		Assert.assertEquals(esperado, resultado);
	}

}
