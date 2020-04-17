package de.stefanschade.primefacesshowcase.frontend.beans;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;

public class LanguageValueChangeListener implements ValueChangeListener {

	@Override
	public void processValueChange(ValueChangeEvent e) throws AbortProcessingException {
		System.out.println("Template selected "+e.getNewValue());
	}

}
