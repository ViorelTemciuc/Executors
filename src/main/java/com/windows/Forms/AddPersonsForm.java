package com.windows.Forms;


import javax.servlet.ServletContext;



public abstract class AddPersonsForm {
	
	String name;
	String IDNP;
	String adress1;
	String adress2;
	String email;
	
	public abstract String generate_form_contains(ServletContext con);
	//public Map<String,String> elementsHtmlWidgets;
	
	

}
