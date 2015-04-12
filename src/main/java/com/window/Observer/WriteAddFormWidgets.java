package com.window.Observer;

import java.io.FileWriter;
import java.io.IOException;


import com.window.globals.widgetList;

public class WriteAddFormWidgets implements Observer,Writer {

	private String file;
	private widgetList o;
	private WriteFileSubject fileWriter;
	
	public WriteAddFormWidgets(WriteFileSubject fileWriter1) {
		this.fileWriter=fileWriter1;
		fileWriter.registerObserver(this);
	}
	@Override
	public void write() throws IOException {
		FileWriter writer=new FileWriter(this.file);
		writer.write("function generateForm(){");
		for(String str:o.getWidgets()){
			writer.write(str);
		}
		writer.write("}");
		writer.close();
		
	}

	@Override
	public void update(String filePath) {
		
		
		file=filePath;
		o=widgetList.getInstance();
		try {
			write();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
