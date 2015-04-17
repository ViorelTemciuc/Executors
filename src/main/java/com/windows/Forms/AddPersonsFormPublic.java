package com.windows.Forms;

import javax.servlet.ServletContext;

import com.window.Observer.WriteAddFormWidgets;
import com.window.Observer.WriteJSFile;
import com.window.globals.widgetList;
import com.window.toolbox.Button;
import com.window.toolbox.Label;
import com.window.toolbox.TextBox;

public class AddPersonsFormPublic extends AddPersonsForm {

 private String legend;
 private String action;
 private String id;
 
  
 public AddPersonsFormPublic(){
  this.legend="Adaugare Persona Juridica";
  this.action="/personsAdd";
  this.id="PPForm";
  widgetList o=widgetList.getInstance();
  o.emptyList();
  
 }
 public String generate_checkbox(){
  return "<input type='checkbox' name='type' value='solidar'/>Solidar<br/>";
 }
 private String generate_buttons(){ 
  
  String buttonAdd=new Button.Builder("submit_Debtor", "OK", "submit").disabled(false).build().getButton();
  String buttonDelete=new Button.Builder("delete_Debtor", "Delete", "button").disabled(true).build().getButton();
  String buttonCancel=new Button.Builder("cancel_Debtor", "Cancel", "button").disabled(false).build().getButton();
  return buttonAdd+buttonDelete+buttonCancel;
 }
 
 private String generate_textboxes(){
  
  name=new TextBox.Builder("name", "Introduceti denumirea (ex. SRL Mold)").build().concatenator(new Label("name","Denumire"));
  IDNP=new TextBox.Builder("idnp", "Introduceti Codul Fiscal (ex.200288871111)").build().concatenator(new Label("idnp","Cod Fiscal"));
  adress1=new TextBox.Builder("adress1", "Introduceti adresa de resedinta").build().concatenator(new Label("adress1","Adresa de resedinta"));
  adress2=new TextBox.Builder("adress2", "Introduceti adresa de corespondenta daca exista").build().concatenator(new Label("adress2","Adresa de corespondenta"));
  email=new TextBox.Builder("email", "Introduceti adresa de E-mail").build().concatenator(new Label("email","Email"));
    return name+IDNP+adress1+adress2+email;
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
  new WriteAddFormWidgets(jsfFile);
  String filePath=context.getRealPath("/")+"resources/myJsWidgeds/formAddWidget.js";
  jsfFile.widgetsChanged(filePath);
 }
}