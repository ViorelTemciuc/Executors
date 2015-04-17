package com.service;

import com.entities.Incheiere;

public interface IncheiereService {
	public Incheiere getIncheiereById(int id);
	public void addIncheiere(Incheiere incheiere);
    public void updateIncheiere(Incheiere incheiere);
    public void deleteIncheiere(Incheiere incheiere);

}
