package edu.rms.business.Impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rms.business.RiskItemBusiness;
import edu.rms.dao.RiskItemDao;
import edu.rms.dao.RiskStateTrackDao;
import edu.rms.dao.UserDao;
import edu.rms.model.RiskItem;


@Service
public class RiskItemBusinessImpl implements RiskItemBusiness{
	@Autowired
	private RiskItemDao riskItemDao;
	@Autowired
	private UserDao udao;
	
	@Autowired
	private RiskStateTrackDao rDao;
	
	@Override
	public String addRiskItem(RiskItem riskItem) {
		String[] temp=riskItem.getTracker_id().split(";");
		String trackername="";
		for(int i=0;i<temp.length;i++){
			String a=udao.getById(Integer.parseInt(temp[i])).getUser_name();
			trackername=trackername+a+";";
		}
		trackername=trackername.substring(0,trackername.length()-1);
		riskItem.setTracker_name(trackername);
		return riskItemDao.save(riskItem);
	}

	@Override
	public List<RiskItem> getAllRiskItem() {
		
		return riskItemDao.getAll();
	}

	@Override
	public List<RiskItem> getMyRiskItem(int userid) {
		List<RiskItem> temp=riskItemDao.getAll();
		List<RiskItem> re=new ArrayList<RiskItem>();
		
		
		String tr="";
		String[] trs=null;
		for(int i=0;i<temp.size();i++){
			tr=temp.get(i).getTracker_id();
			trs=tr.split(";");
			for(int j=0;j<trs.length;j++){
				if(trs[j].equals(String.valueOf(userid))){
					
					re.add(temp.get(i));
				}
			}
		}
		return re;
	}

	@Override
	public RiskItem getRiskById(String riskItemid) {
		// TODO Auto-generated method stub
		return riskItemDao.getRiskById(riskItemid);
	}

	@Override
	public List<RiskItem> getItemListByIdList(List<String> tempIdList) {
		List<RiskItem> re=new ArrayList<RiskItem>();
		RiskItem temp=new RiskItem();
		for(int i=0;i<tempIdList.size();i++){
			temp=riskItemDao.getRiskById(tempIdList.get(i));
			re.add(temp);
		}
		return re;
	}

	@Override
	public List<RiskItem> getRiskItemByReg(Timestamp beginTime, Timestamp endTime) {
		List<String> re;
		if(beginTime==null){
			re=rDao.getRecTimesNoTime();
		}else{
			re=rDao.getRecTimes(beginTime.toString(), endTime.toString());
		}
		String[] temp;
		List<RiskItem> result=new ArrayList<RiskItem>();
		for(int i=0;i<re.size();i++){
			temp=re.get(i).split(";");
			result.add(riskItemDao.getRiskById(temp[0]));
		}
		return result;
	}

	@Override
	public List<RiskItem> getRiskItemByPro(Timestamp beginTime, Timestamp endTime) {
		List<String> re;
		if(beginTime==null){
			re=rDao.getProblemNoTime();
		}else{
			re=rDao.getProblemTimes(beginTime.toString(), endTime.toString());
		}
		String[] temp;
		List<RiskItem> result=new ArrayList<RiskItem>();
		for(int i=0;i<re.size();i++){
			temp=re.get(i).split(";");
			result.add(riskItemDao.getRiskById(temp[0]));
		}
		return result;
	}

}
