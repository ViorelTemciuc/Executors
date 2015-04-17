package com.service;

import java.util.List;

import com.entities.CoCreditor;

public interface CoCreditorService {
	public void addPerson(CoCreditor creditor);
	public void updatePersons(CoCreditor creditor);
	public void deletePersons(CoCreditor creditor);
	public List<CoCreditor> getAllCoCreditorsByIncheiere(int incheiere_id);
}
