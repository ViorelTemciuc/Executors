package com.window.globals;

import java.util.ArrayList;
import java.util.List;

public class widgetList {
 private volatile static widgetList uniqueInstance;
 List<String> widgets;
 private widgetList(){
  this.widgets=new ArrayList<String>();
 }
    
 public static widgetList getInstance(){
  if(uniqueInstance==null){
   synchronized (widgetList.class) {
    if(uniqueInstance==null){
     uniqueInstance=new widgetList();
    }
   }
  }
  return uniqueInstance;
 }

 public List<String> getWidgets() {
  return widgets;
 }
    public void emptyList(){
     widgets.clear();
    }
 public void addWidgets(String widget) {
  this.widgets.add(widget);
 }
 
}