package com.window.toolbox;

import java.util.List;

import com.window.globals.widgetList;

public class TextBox {
	
	private final String placeHolder;
	private final String id;
	private final int height;
	private final int width;
	private final List source;
	private final int minLength;
	
	
	public static class Builder{
		//required parameters for building textbox;
		private final String placeHolder;
		private final String id;
		//optional parameters
		private int height;
		private int width;
		private List source;
		private int minLength;
		
	
	public Builder(String id, String placeHolder){
		this.id=id;
		this.placeHolder=placeHolder;
	}
	public Builder height(int val){
		height=val;return this;
	}
	public Builder width(int val){
		width=val;return this;
	}
	public Builder source(List val){
		source=val;return this;
	}
	public Builder minLength(int val){
		minLength=val;return this;
	}
	public TextBox build(){
		return new TextBox(this);
	}
	}
	public TextBox(Builder builder){
		placeHolder= builder.placeHolder;
		id=builder.id;
		height=builder.height;
		width=builder.width;
		source=builder.source;
		minLength=builder.minLength;
	}
	private void construct_TextBox_widget(){
		String widgetString="$('#"+id+"')"
				+ ".jqxInput({placeHolder:'"+placeHolder+"',height:"
				+height+",width:"+width+",minLength:"+minLength+"});";
		widgetList widget=widgetList.getInstance();
		widget.addWidgets(widgetString);
				
	}
	private String setTextBox(){
		return "<input id='"+id+"' name='"+id+"'/>";
	}
	private String setLabel(Label L){
		return "<label for = "+L.getForW()+">"+L.getText()+"</label>";
	}
	public String concatenator(Label L){
		construct_TextBox_widget();
		return setLabel(L)+setTextBox();
	}
	

}
