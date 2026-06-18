package jakarta_jpa.uteis;

import java.util.Iterator;

import jakarta.faces.FacesException;
import jakarta.faces.context.ExceptionHandler;
import jakarta.faces.context.ExceptionHandlerWrapper;
import jakarta.faces.event.ExceptionQueuedEvent;
import jakarta.faces.event.ExceptionQueuedEventContext;

@SuppressWarnings("deprecation")
public class TratadorErro extends ExceptionHandlerWrapper {

	private ExceptionHandler wrapped;

	public TratadorErro(ExceptionHandler wrapped) {
		this.wrapped = wrapped;
	}

	@Override
	public void handle() throws FacesException {
		Iterator<ExceptionQueuedEvent> events = getUnhandledExceptionQueuedEvents().iterator();
		while (events.hasNext()) {
			ExceptionQueuedEvent event = events.next();
			ExceptionQueuedEventContext context = (ExceptionQueuedEventContext) event.getSource();
			Throwable exception = context.getException();
			System.out.println(exception.getMessage());
		}
	}

	@Override
	public ExceptionHandler getWrapped() {
		return this.wrapped;
	}

}
