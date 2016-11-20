package edu.rms.business;

import java.util.List;

import edu.rms.model.RaItems;

public interface RaItemsBusiness {

	public List<String> getOneRAItems(int raid);
	
	public List<RaItems> getOneRaItems(int raid);
	
	public String save(RaItems raitem);
	
	
}
