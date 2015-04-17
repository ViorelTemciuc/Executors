package com.DAO;

import com.entities.Incheiere;


public interface IncheiereDAO {
	public Incheiere getIncheiereById(int id);
	public void addIncheiere(Incheiere incheiere);
    public void updateIncheiere(Incheiere incheiere);
    public void deleteIncheiere(Incheiere incheiere);
}
