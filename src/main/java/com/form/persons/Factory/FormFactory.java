package com.form.persons.Factory;

import javax.servlet.ServletContext;

import com.windows.Forms.AddPersonsForm;
import com.windows.Forms.AddPersonsFormPrivate;
import com.windows.Forms.AddPersonsFormPublic;

public class FormFactory {
	
	public static String generateForm(FormType f,ServletContext context){
		AddPersonsForm form=null;
		String formStringHTML=null;
		switch(f){
		case privateForm:
			form=new AddPersonsFormPrivate();
			formStringHTML=form.generate_form_contains(context);
			break;
		case publicForm:
			form=new AddPersonsFormPublic();
			formStringHTML=form.generate_form_contains(context);
			
		}
		return formStringHTML;
		
			
	}

}
