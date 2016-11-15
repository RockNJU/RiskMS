package com.rms.dao;

import java.util.List;

import com.rms.model.RiskItem;

public interface RiskItemDao {

	public List<RiskItem> getAll();
	
	public String save(RiskItem riskItem);
	
}
