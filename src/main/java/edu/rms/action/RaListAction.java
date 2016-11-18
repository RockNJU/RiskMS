package edu.rms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.rms.business.RaItemsBusiness;
import edu.rms.business.RaListBusiness;
import edu.rms.business.RiskItemBusiness;
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
	
	//所有的风险计划
	private List<RaList> allralist;
	
	//单个风险计划id和id下的所有风险条目
	private int ralist_id;
	private List<RiskItem> riskitem;
	
	//所增加的风险计划和该风险计划下所有的风险条目
	private RaList add_ralist;
	private String add_raitems;
	
	//我觉得这个需要看界面是怎么要的
	//查询到的被识别最多的风险条目的信息
	//查询到的转变成问题最多的风险条目的信息
	
	
	
	public int getRalist_id() {
		return ralist_id;
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

	public String getAdd_raitems() {
		return add_raitems;
	}

	public void setAdd_raitems(String add_raitems) {
		this.add_raitems = add_raitems;
	}

	public void setAllralist(List<RaList> allralist) {
		this.allralist = allralist;
	}

	
	/*---start all method----*/
	
	public void getAllralist(){
		allralist=ralistbusiness.getAll();
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
		String re=ralistbusiness.save(add_ralist);
		String reforitem="success";
		if(re.equals("新增计划成功")){
			//保存所有的reitem
			String[] temp=add_raitems.split(";");
			RaItems a=new RaItems();
			
			for(int i=0;i<temp.length;i++){
				a.setRaItem_id(Integer.parseInt(temp[i]));
				a.setRiskItem_id(newid);
				String te=raitemsbusiness.save(a);
				if(!te.equals("success")){
					reforitem=te;
				}
			}
		}else{
			reforitem="false";
		}
		if(reforitem.equals("success")){
			return SUCCESS;
		}else{
			return INPUT;
		}
		
		
	}
	
	
	
	
	
}
