package com.window.Observer;

public interface WriteFileSubject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObserver();

}
