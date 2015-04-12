package com.windows.Forms;

import com.window.globals.widgetList;

public class AjaxFormSubmit {

	String url;
	String id;
	public AjaxFormSubmit(String id,String url){
		this.url=url;
		this.id=id;
	}
	public void setFunction(){
		widgetList widget=widgetList.getInstance();
		widget.addWidgets("id='"+id+"';url='"+url+"';");
	}
}
