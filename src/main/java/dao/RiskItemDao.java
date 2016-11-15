package dao;

import java.util.List;

import model.RiskItem;

public interface RiskItemDao {

	public List<RiskItem> getAll();
	
	public String save(RiskItem riskItem);
	
}
