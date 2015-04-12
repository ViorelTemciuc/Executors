package com.window.toolbox;

public class Button {
	
	private final String id;
	private final String value;
	private final String type;
	private final String actionURL;
	private final int width;
	private final boolean disabled;
	
	public static class Builder{
		//Required parameters
	private final String id;
	private final String value;
	private final String type;
	  //Optional parameters
	private String actionURL="none";
	private int width;
	private boolean disabled=false;
	public Builder(String id, String value, String type){
		this.id=id;
		this.value=value;
		this.type=type;
	}
	public Builder actionURL(String val){
		actionURL=val;return this;
	}
	public Builder width(int val){
		width=val; return this;
	}
	public Builder disabled(boolean val){
		disabled=val;return this;
	}
	public Button build(){
		return new Button(this);
	}	
	}

	private Button(Builder builder){
		id=builder.id;
		value=builder.value;
		type=builder.type;
		actionURL=builder.actionURL;
		width=builder.width;
		disabled=builder.disabled;
	}
	
	public String getButton(){
		return "<input id='"+id+"' type='"+type+"' value='"+value+"'/>";
	}
	public String getWidget(){
		return "$('#'"+id+").jqxButton(width:"+width+",disabled:"+disabled+")";
	}
	
	
}
