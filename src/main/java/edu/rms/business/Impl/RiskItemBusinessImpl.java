package edu.rms.business.Impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	public List<RiskItem> getRiskItemByReg(String beginTime, String endTime) {
		
		List<String> re;
		
		String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		
		Pattern pat = Pattern.compile(rexp);  
		
		Matcher mat = pat.matcher(beginTime);  
		
		boolean dateType = mat.matches();
		if(!dateType){
			re=rDao.getRecTimesNoTime();
		}else{
			re=rDao.getRecTimes(beginTime, endTime);
		}
		String[] temp;
		List<RiskItem> result=new ArrayList<RiskItem>();
		System.out.println("shuchu"+beginTime+" "+endTime);
		if(result==null){
			System.out.println("nullle");
			return result;
		}else{
		for(int i=0;i<re.size();i++){
			temp=re.get(i).split(";");
			System.out.println("adale"+result.size());
			result.add(riskItemDao.getRiskById(temp[0]));
		}
		return result;
		}
	}

	@Override
	public List<RiskItem> getRiskItemByPro(String beginTime, String endTime) {
        List<String> re;
		
		String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";
		
		Pattern pat = Pattern.compile(rexp);  
		
		Matcher mat = pat.matcher(beginTime);  
		
		boolean dateType = mat.matches();
		if(!dateType){
			re=rDao.getProblemNoTime();
		}else{
			re=rDao.getProblemTimes(beginTime.toString(), endTime.toString());
		}
		String[] temp;
		List<RiskItem> result=new ArrayList<RiskItem>();
		if(result==null){
			return result;
		}else{
		for(int i=0;i<re.size();i++){
			temp=re.get(i).split(";");
			result.add(riskItemDao.getRiskById(temp[0]));
		}
		return result;
		}
	}

}
