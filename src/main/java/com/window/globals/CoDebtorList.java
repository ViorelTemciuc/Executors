package com.window.globals;

import java.util.ArrayList;
import java.util.List;

import com.entities.Persons;

public class CoDebtorList extends AbstractCDClass {
	private volatile static CoDebtorList uniqueInstance;
	List<Persons> coDebtor;
	private CoDebtorList(){
		this.coDebtor=new ArrayList<Persons>();
	}
    
	public static CoDebtorList getInstance(){
		if(uniqueInstance==null){
			synchronized (CoDebtorList.class) {
				if(uniqueInstance==null){
					uniqueInstance=new CoDebtorList();
				}
			}
		}
		return uniqueInstance;
	}

	public List<Persons> getTor() {
		return coDebtor;
	}

	public void addTor(Persons list) {
		this.coDebtor.add(list);
	}
	
	public void editTor(Persons p,int index) {
		
		coDebtor.set(index, p);		
	
}
	public void deleteTor(Persons p) {
		
		int i=coDebtor.indexOf(p);
		coDebtor.remove(i);		
	
	}
}
