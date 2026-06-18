package jakarta.uteis;

import jakarta.faces.context.ExceptionHandler;
import jakarta.faces.context.ExceptionHandlerFactory;

@SuppressWarnings("deprecation")
public class TratadorErroFactory extends ExceptionHandlerFactory {

	private ExceptionHandlerFactory parent;
	
	public TratadorErroFactory(ExceptionHandlerFactory parent) {
		this.parent = parent;
	}
	
	@Override
	public ExceptionHandler getExceptionHandler() {
		return new TratadorErro(parent.getExceptionHandler());
	}

	
}
