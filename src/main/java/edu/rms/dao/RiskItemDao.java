package edu.rms.dao;

import java.util.List;

import edu.rms.model.RiskItem;

public interface RiskItemDao {

	public List<RiskItem> getAll();
	
	public String save(RiskItem riskItem);
	
	public List<RiskItem> findbykey(String key);
}
