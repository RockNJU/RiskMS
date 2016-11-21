package edu.rms.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.rms.business.RaItemsBusiness;
import edu.rms.business.RaListBusiness;
import edu.rms.business.RiskItemBusiness;
import edu.rms.business.RiskStateTrackBusiness;
import edu.rms.model.RaItems;
import edu.rms.model.RaList;
import edu.rms.model.RiskItem;

@Component
public class RaListAction extends BaseAction{

	@Autowired
	private RaListBusiness ralistbusiness;
	
	@Autowired
	private RaItemsBusiness raitemsbusiness;
	
	@Autowired
	private RiskItemBusiness riskitembusiness;
	
	@Autowired
	private RiskStateTrackBusiness riskstatetrackbusiness;
	

	private List<RaList> allralist;

	private int ralist_id;
	private List<RiskItem> riskitem;

	private RaList add_ralist;
	private List<String> tempIdList;
	

	private List<RiskItem> optionalItemList;
	private List<RiskItem> selectedItemList;
	

	private RaList unmodifyRA;
	private RaList hasmodifyRA;

	
	
	public RaList getUnmodifyRA() {
		return unmodifyRA;
	}

	public void setUnmodifyRA(RaList unmodifyRA) {
		this.unmodifyRA = unmodifyRA;
	}

	public RaList getHasmodifyRA() {
		return hasmodifyRA;
	}

	public void setHasmodifyRA(RaList hasmodifyRA) {
		this.hasmodifyRA = hasmodifyRA;
	}

	public List<RiskItem> getSelectedItemList() {
		return selectedItemList;
	}

	public void setSelectedItemList(List<RiskItem> selectedItemList) {
		this.selectedItemList = selectedItemList;
	}

	public List<String> getTempIdList() {
		return tempIdList;
	}

	public void setTempIdList(List<String> tempIdList) {
		this.tempIdList = tempIdList;
	}


	public int getRalist_id() {
		return ralist_id;
	}
	
	public List<RiskItem> getOptionalItemList() {
		return optionalItemList;
	}

	public void setOptionalItemList(List<RiskItem> optionalItemList) {
		this.optionalItemList = optionalItemList;
	}

	public void setRalist_id(int ralist_id) {
		this.ralist_id = ralist_id;
	}

	public List<RiskItem> getRiskitem() {
		return riskitem;
	}

	public void setRiskitem(List<RiskItem> riskitem) {
		this.riskitem = riskitem;
	}

	public RaList getAdd_ralist() {
		return add_ralist;
	}

	public void setAdd_ralist(RaList add_ralist) {
		this.add_ralist = add_ralist;
	}


	public void setAllralist(List<RaList> allralist) {
		this.allralist = allralist;
	}
	public List<RaList> getAllralist() {
		return allralist;
	}
	
	/*---start all method----*/
	
	public String getAllRAlist(){
		allralist=ralistbusiness.getAll();
		optionalItemList = riskitembusiness.getAllRiskItem();
		session.put("optionList", optionalItemList);
		if(tempIdList==null){
			tempIdList = new ArrayList<String>();
			session.put("tempItemId", tempIdList);
		}
		return SUCCESS;
	}
	
	public String getItemByReg(){
		String beginTime = (String)(req.getParameter("bt"));
		String endTime = (String)(req.getParameter("et"));
		optionalItemList = riskitembusiness.getRiskItemByReg(beginTime,endTime);
		session.put("optionList", optionalItemList);
		refreshTempItemListTable();
		return SUCCESS;
	}
	
	public String getItemByPro(){
		String beginTime = (String)(req.getParameter("bt"));
		String endTime = (String)(req.getParameter("et"));
		optionalItemList = riskitembusiness.getRiskItemByPro(beginTime,endTime);
		
		session.put("optionList", optionalItemList);
		refreshTempItemListTable();
		return SUCCESS;
	}
	
	public String getAllItem(){
		optionalItemList = riskitembusiness.getAllRiskItem();
		session.put("optionList", optionalItemList);
		refreshTempItemListTable();
		return SUCCESS;
	}
	
	public String getOneRiskAllItems(){
		List<RaItems> temp=raitemsbusiness.getOneRaItems(ralist_id);
		riskitem.clear();
		for(int i=0;i<temp.size();i++){
			riskitem.add(riskitembusiness.getRiskById(String.valueOf(temp.get(i).getRiskItem_id())));
		}
		return SUCCESS;
	}
	
	public String addRaList(){
		//保存ralist
		int newid=ralistbusiness.getAll().size()+1;
		String re=ralistbusiness.save(add_ralist);
		String reforitem="success";
		tempIdList=(List<String>)session.get("tempItemId");
		if(re.equals("新增计划成功")){
			//保存所有的reitem
			RaItems a=new RaItems();
			
			for(int i=0;i<tempIdList.size();i++){
				a.setRiskItem_id(Integer.parseInt(tempIdList.get(i)));
				a.setRa_id(newid);
				String te=raitemsbusiness.save(a);
				if(!te.equals("success")){
					reforitem=te;
				}
			}
		}else{
			reforitem="false";
		}
		if(reforitem.equals("success")){
			tempIdList.clear();
			allralist=ralistbusiness.getAll();
			refreshTempItemListTable();
			return SUCCESS;
		}else{
			return INPUT;
		}
		
		
	}
	
	public String addTempItemId(){
		String id = (String)(req.getParameter("addTempItemId"));
		tempIdList=(List<String>)session.get("tempItemId");
		if(tempIdList==null){
			tempIdList = new ArrayList<String>();
		}
		if(tempIdList.indexOf(id)==-1){
			tempIdList.add(id);
			session.put("tempItemId", tempIdList);
		}
		refreshTempItemListTable();
		return SUCCESS;
		
	}
	
	public String rmvTempItemId(){
		String id = (String)(req.getParameter("rmvTempItemId"));
		tempIdList=(List<String>)session.get("tempItemId");
		tempIdList.remove(id);
		session.put("tempItemId", tempIdList);
		refreshTempItemListTable();
		return SUCCESS;
		
	}

	private void refreshTempItemListTable() {
		selectedItemList=riskitembusiness.getItemListByIdList((List<String>)session.get("tempItemId"));
		optionalItemList = (List<RiskItem>)session.get("optionList");
	}
	
	
	public String deleteRA(){
		int id = Integer.parseInt(req.getParameter("raId"));
		ralistbusiness.deleteRA(id);
		
		allralist=ralistbusiness.getAll();
		optionalItemList = riskitembusiness.getAllRiskItem();
		session.put("optionList", optionalItemList);
		if(tempIdList==null){
			tempIdList = new ArrayList<String>();
			session.put("tempItemId", tempIdList);
		}
		return SUCCESS;
	}
	
	public String getRAtoModify(){
		int id = 0;
		if(req.getParameter("raId")==null){
			id=(int)(req.getAttribute("raId"));
		}else{
		 id = Integer.parseInt(req.getParameter("raId"));
		}
		
		session.put("showRAId", id);
		
		List<String> itemIdList = raitemsbusiness.getOneRAItems(id);
		
		session.put("tempItemId", itemIdList);
		unmodifyRA = ralistbusiness.getRAbyId(id);
		session.put("unmodifyRA", unmodifyRA);
		optionalItemList = riskitembusiness.getAllRiskItem();
		session.put("optionList", optionalItemList);
		refreshTempItemListTable();
		
		return SUCCESS;
	}
	
	public String updateRAtoModify(){
		List<String> itemList = (List<String>)session.get("tempItemId");
		unmodifyRA = (RaList)session.get("unmodifyRA");

		 ralistbusiness.updateRAbyId(unmodifyRA.getRa_id(),hasmodifyRA.getRa_name(),itemList);
		 
		 
			
			
			List<String> itemIdList = raitemsbusiness.getOneRAItems(unmodifyRA.getRa_id());
			
			session.put("tempItemId", itemIdList);
			unmodifyRA = ralistbusiness.getRAbyId(unmodifyRA.getRa_id());
			session.put("unmodifyRA", unmodifyRA);
			optionalItemList = riskitembusiness.getAllRiskItem();
			session.put("optionList", optionalItemList);
			allralist=ralistbusiness.getAll();
			refreshTempItemListTable();
		return SUCCESS;
	}
	
}
