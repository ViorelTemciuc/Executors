package com.windows.Forms;


import javax.servlet.ServletContext;

import com.window.Observer.WriteAddFormWidgets;
import com.window.Observer.WriteJSFile;
import com.window.toolbox.Label;
import com.window.toolbox.TextBox;
import com.window.toolbox.Button;;

public class AddPersonsFormPrivate extends AddPersonsForm{
	
	private String sname;
	private String legend;
	private String action;
	private String id;
	
		
	public AddPersonsFormPrivate(){
		this.legend="Adaugare Persona Fizica";
		this.action="http://localhost:5080/executors/perssons/personsAdd";
		this.id="PPForm";
		
	}
	public String generate_checkbox(){
		return "<input id='subType' type='checkbox' name='type' value='co'/>Co<br/>";
	}
	private String generate_buttons(){ 
		
		String buttonAdd=new Button.Builder("submit_Debtor", "OK", "submit").disabled(false).build().getButton();
		String buttonDelete=new Button.Builder("delete_Debtor", "Delete", "button").disabled(true).build().getButton();
		String buttonCancel=new Button.Builder("cancel_Debtor", "Cancel", "button").disabled(false).build().getButton();
		return buttonAdd+buttonDelete+buttonCancel;
	}
	
	private String generate_textboxes(){
		
		name=new TextBox.Builder("name", "Introduceti nume (ex.Popescu)").build().concatenator(new Label("name","Nume"));
		sname=new TextBox.Builder("sname", "Introduceti prenumele (ex.Gheorghe)").build().concatenator(new Label("sname","Prenume"));
		IDNP=new TextBox.Builder("idnp", "Introduceti cod numeric personal (ex.200288871111)").build().concatenator(new Label("idnp","IDNP"));
		adress1=new TextBox.Builder("adress1", "Introduceti adresa de domiciliu").build().concatenator(new Label("adress1","Adresa de Domiciliu"));
		adress2=new TextBox.Builder("adress2", "Introduceti adresa de corespondenta daca exista").build().concatenator(new Label("adress2","Adresa de corespondenta"));
		email=new TextBox.Builder("email", "Introduceti adresa de E-mail").build().concatenator(new Label("email","Email"));
				return name+sname+IDNP+adress1+adress2+email;
	}
	public String generate_form_contains(ServletContext context){
		String form="<form  id='"+this.id+"'>";
		form+="<legend>"+this.legend+"</legend><fieldset>";
		form+=generate_textboxes();
		form+=generate_checkbox();
		form+="<div>"+generate_buttons()+"</div></fieldset>";
		form+="</form>";
		AjaxFormSubmit submit=new AjaxFormSubmit(this.id, this.action);
		submit.setFunction();
		generate_widget_file(context);
		return form;
	}
	private void generate_widget_file(ServletContext context){
		WriteJSFile jsfFile=new WriteJSFile();
		WriteAddFormWidgets addForm=new WriteAddFormWidgets(jsfFile);
		String filePath=context.getRealPath("/")+"resources/myJsWidgeds/formAddWidget.js";
		jsfFile.widgetsChanged(filePath);
	}
}
