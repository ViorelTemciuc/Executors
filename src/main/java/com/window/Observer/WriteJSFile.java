package com.window.Observer;

import java.util.ArrayList;

public class WriteJSFile implements WriteFileSubject{
	
	private ArrayList observers;
	private String filePath;

	public WriteJSFile(){
		observers=new ArrayList();
	}
	@Override
	public void registerObserver(Observer o) {
		
		observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if(i>=0){
			observers.remove(i);
		}
		
	}

	@Override
	public void notifyObserver() {
		for(int i=0; i<observers.size();i++){
			Observer observer = (Observer)observers.get(i);
			observer.update(filePath);
		}
				
	}
	public void widgetsChanged(String filePath){
		this.filePath=filePath;
		notifyObserver();
	}
	
	
	

}
