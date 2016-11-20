package edu.rms.dao;

import java.util.List;

import edu.rms.model.RaList;

public interface RaListDao {
	
	public List<RaList> getAll();
	
	public String save(RaList ra);

	public String delete(int raid);
	
}
