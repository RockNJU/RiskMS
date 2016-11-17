package edu.rms.dao;

import java.util.List;

import edu.rms.model.RaItems;

public interface RaItemsDao {

	public List<RaItems> getOneRAItems(int raid);
	
	public String save(RaItems ra);
}
