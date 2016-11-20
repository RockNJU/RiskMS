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
	
	//所有的风险计划
	private List<RaList> allralist;
	
	//单个风险计划id和id下的所有风险条目
	private int ralist_id;
	private List<RiskItem> riskitem;
	
	//所增加的风险计划和该风险计划下所有的风险条目id
	private RaList add_ralist;
	private List<String> tempIdList;
	
	//所有可选的风险条目
	private List<RiskItem> optionalItemList;
	private List<RiskItem> selectedItemList;
	
	//我觉得这个需要看界面是怎么要的
	//查询到的被识别最多的风险条目的信息
	//查询到的转变成问题最多的风险条目的信息

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
		System.out.println(beginTime+"  dadadaf   "+endTime);
		for(int i=0;i<optionalItemList.size();i++){
			System.out.println("dasdadad"+optionalItemList.get(i).getRiskItem_id());
		}
		
		session.put("optionList", optionalItemList);
		refreshTempItemListTable();
		return SUCCESS;
	}
	
	public String getItemByPro(){
		String beginTime = (String)(req.getParameter("bt"));
		String endTime = (String)(req.getParameter("et"));
		optionalItemList = riskitembusiness.getRiskItemByPro(beginTime,endTime);
		System.out.println(beginTime+"  dadadaf   "+endTime);
		for(int i=0;i<optionalItemList.size();i++){
			System.out.println("dasdadad"+optionalItemList.get(i).getRiskItem_id());
		}
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
		List<RaItems> temp=raitemsbusiness.getOneRAItems(ralist_id);
		riskitem.clear();
		for(int i=0;i<temp.size();i++){
			riskitem.add(riskitembusiness.getRiskById(String.valueOf(temp.get(i).getRiskItem_id())));
		}
		return SUCCESS;
	}
	
	public String addRaList(){
		//保存ralist
		int newid=ralistbusiness.getAll().size()+1;
		System.out.println(newid);
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
	
	
	
	
	
}
