package edu.rms.business;

import java.util.List;

import edu.rms.model.RaList;

public interface RaListBusiness {
	
	//获取所有的风险计划
	public List<RaList> getAll();
	
	
	public String save(RaList ra);


	public void deleteRA(int id);


	public RaList getRAbyId(int id);


	public void updateRAbyId(int ra_id, String ra_name, List<String> itemList);
}
