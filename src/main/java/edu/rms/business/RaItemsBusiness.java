package edu.rms.business;

import java.util.List;

import edu.rms.model.RaItems;

public interface RaItemsBusiness {

	public List<RaItems> getOneRAItems(int raid);
	
	public String save(RaItems raitem);
	
	public String remove(RaItems raitem);
}
