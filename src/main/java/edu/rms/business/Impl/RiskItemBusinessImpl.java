package edu.rms.business.Impl;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
		boolean dateType=valiDateTimeWithLongFormat(beginTime);		
		if(!dateType){
			
			re=rDao.getRecTimesNoTime();
		}else{
			
			re=rDao.getRecTimes(beginTime, endTime);
		}
		
		String[] temp;
		List<RiskItem> result=new ArrayList<RiskItem>();
		System.out.println("shuchu"+beginTime+" "+endTime);
		if(re==null){
			System.out.println("nullle");
			return null;
		}else{
			
		for(int i=0;i<re.size();i++){
			temp=re.get(i).split(";");
			
			result.add(riskItemDao.getRiskById(temp[0]));
		}
		System.out.println("查询到的size"+result.size());
		return result;
		}
		
		
	}

	@Override
	public List<RiskItem> getRiskItemByPro(String beginTime, String endTime) {
		List<String> re;
		boolean dateType=valiDateTimeWithLongFormat(beginTime);	
		if(!dateType){
			re=rDao.getProblemNoTime();
		}else{
			re=rDao.getProblemTimes(beginTime.toString(), endTime.toString());
		}
		String[] temp;
		List<RiskItem> result=new ArrayList<RiskItem>();
		if(re==null){
			return null;
		}else{
		for(int i=0;i<re.size();i++){
			temp=re.get(i).split(";");
			result.add(riskItemDao.getRiskById(temp[0]));
		}
		return result;
		}
		
	}

	
	private static boolean valiDateTimeWithLongFormat(String timeStr) {
		String format = "((19|20)[0-9]{2})-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01]) "
				+ "([01]?[0-9]|2[0-3]):[0-5][0-9]";
		Pattern pattern = Pattern.compile(format);
		Matcher matcher = pattern.matcher(timeStr);
		if (matcher.matches()) {
			pattern = Pattern.compile("(\\d{4})-(\\d+)-(\\d+).*");
			matcher = pattern.matcher(timeStr);
			if (matcher.matches()) {
				int y = Integer.valueOf(matcher.group(1));
				int m = Integer.valueOf(matcher.group(2));
				int d = Integer.valueOf(matcher.group(3));
				if (d > 28) {
					Calendar c = Calendar.getInstance();
					c.set(y, m-1, 1);
					int lastDay = c.getActualMaximum(Calendar.DAY_OF_MONTH);
					return (lastDay >= d);
				}
			}
			return true;
		}
		return false;
	}

	@Override
	public Map<String, Integer> getRiskOrderByReg() {
		List<String> str=rDao.getRecTimesNoTime();
		Map<String, Integer> re=new HashMap<String, Integer>();
		if(str==null){
			return null;
		}else{
			String temp[];
			RiskItem ri=new RiskItem();
			for(int i=0;i<str.size();i++){
				temp=str.get(i).split(";");//id+cishu
				ri=riskItemDao.getRiskById(temp[0]);
				re.put(ri.getContent(), Integer.parseInt(temp[1]));
			}
		
			return re;
		}
	}

	@Override
	public Map<String, Integer> getRiskOrderByPro() {
		List<String> str=rDao.getProblemNoTime();
		Map<String, Integer> re=new HashMap<String, Integer>();
		if(str==null){
			return null;
		}else{
			String temp[];
			RiskItem ri=new RiskItem();
			for(int i=0;i<str.size();i++){
				temp=str.get(i).split(";");//id+cishu
				ri=riskItemDao.getRiskById(temp[0]);
				re.put(ri.getContent(), Integer.parseInt(temp[1]));
			}
		
			return re;
		}
	}

	@Override
	public Map<String, Integer> getRiskOrderByRegTime(String beginTime, String endTime) {
		boolean dateType=valiDateTimeWithLongFormat(beginTime);	
		List<String> str=new ArrayList<String>();
		if(!dateType){
			str=rDao.getRecTimesNoTime();
		}else{
			str=rDao.getRecTimes(beginTime, endTime);
		}
		
		
		Map<String, Integer> re=new HashMap<String, Integer>();
		if(str==null){
			return null;
		}else{
			String temp[];
			RiskItem ri=new RiskItem();
			for(int i=0;i<str.size();i++){
				temp=str.get(i).split(";");//id+cishu
				ri=riskItemDao.getRiskById(temp[0]);
				re.put(ri.getContent(), Integer.parseInt(temp[1]));
			}
		
			return re;
		}
	}

	@Override
	public Map<String, Integer> getRiskOrderByProTime(String beginTime, String endTime) {
		boolean dateType=valiDateTimeWithLongFormat(beginTime);	
		List<String> str=new ArrayList<String>();
		if(!dateType){
			str=rDao.getProblemNoTime();
		}else{
			str=rDao.getProblemTimes(beginTime, endTime);
		}
		
		
		Map<String, Integer> re=new HashMap<String, Integer>();
		if(str==null){
			return null;
		}else{
			String temp[];
			RiskItem ri=new RiskItem();
			for(int i=0;i<str.size();i++){
				temp=str.get(i).split(";");//id+cishu
				ri=riskItemDao.getRiskById(temp[0]);
				re.put(ri.getContent(), Integer.parseInt(temp[1]));
			}
		
			return re;
		}
	}
}
