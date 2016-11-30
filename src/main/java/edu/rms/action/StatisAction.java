package edu.rms.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import edu.rms.business.RiskItemBusiness;

@Component
public class StatisAction extends BaseAction {
	
	@Autowired
	private RiskItemBusiness riskitembusiness;

	private StringBuilder itemsReg=new StringBuilder();
	private StringBuilder riskRatioReg=new StringBuilder();
	private StringBuilder itemsPro=new StringBuilder();
	private StringBuilder riskRatioPro=new StringBuilder();
	

	public StringBuilder getItemsReg() {
		return itemsReg;
	}

	public void setItemsReg(StringBuilder itemsReg) {
		this.itemsReg = itemsReg;
	}

	public StringBuilder getRiskRatioReg() {
		return riskRatioReg;
	}

	public void setRiskRatioReg(StringBuilder riskRatioReg) {
		this.riskRatioReg = riskRatioReg;
	}

	public StringBuilder getItemsPro() {
		return itemsPro;
	}

	public void setItemsPro(StringBuilder itemsPro) {
		this.itemsPro = itemsPro;
	}

	public StringBuilder getRiskRatioPro() {
		return riskRatioPro;
	}

	public void setRiskRatioPro(StringBuilder riskRatioPro) {
		this.riskRatioPro = riskRatioPro;
	}

	public String riskStatis() throws ServletException,IOException{
	    allReg();
	    allPro();
		return SUCCESS;
	}
	
	public String proStatisOrder() throws ServletException,IOException{
		proStatisWithTime();
		allReg();
		return SUCCESS;
	}
	
	public String regStatisOrder() throws ServletException,IOException{
		regStatisWithTime();
	    allPro();
		return SUCCESS;
	}
	
	private void allPro(){
		Map<String,Integer> proRisk=riskitembusiness.getRiskOrderByPro();
		Iterator<String> iter2 = proRisk.keySet().iterator();
		itemsPro.append("[");
		riskRatioPro.append("[");
		while(iter2.hasNext()){
			String key=iter2.next();
			itemsPro.append("\""+key+"\""+",");
			int v=proRisk.get(key);
			riskRatioPro.append(v+",");
		}
		itemsPro.append("]");
		riskRatioPro.append("]");
	}
	
	private void allReg(){
		Map<String,Integer> regRisk=riskitembusiness.getRiskOrderByReg();
		Iterator<String> iter = regRisk.keySet().iterator();
		itemsReg.append("[");
		riskRatioReg.append("[");
		while(iter.hasNext()){
			String key=iter.next();
			itemsReg.append("\""+key+"\""+",");
			int v=regRisk.get(key);
			riskRatioReg.append(v+",");
		}
		itemsReg.append("]");
		riskRatioReg.append("]");
	}
	
	
	public String regStatisWithTime() throws ServletException,IOException{
		itemsReg = new StringBuilder();
		riskRatioReg = new StringBuilder();
		String beginTime = (String)(req.getParameter("bt"));
		String endTime = (String)(req.getParameter("et"));
		Map<String,Integer> regRisk=riskitembusiness.getRiskOrderByRegTime(beginTime,endTime);
		
		if(regRisk==null){
			itemsReg.append("[]");
			riskRatioReg.append("[]");
			return SUCCESS;
		}else{
		Iterator<String> iter = regRisk.keySet().iterator();
		itemsReg.append("[");
		riskRatioReg.append("[");
		while(iter.hasNext()){
			String key=iter.next();
			itemsReg.append("\""+key+"\""+",");
			int v=regRisk.get(key);
			riskRatioReg.append(v+",");
		}
		itemsReg.append("]");
		riskRatioReg.append("]");
		return SUCCESS;
		}
	}
	
	public String proStatisWithTime() throws ServletException,IOException{
		
		itemsPro = new StringBuilder();
		riskRatioPro = new StringBuilder();
		String beginTime = (String)(req.getParameter("bt"));
		String endTime = (String)(req.getParameter("et"));
		Map<String,Integer> proRisk=riskitembusiness.getRiskOrderByProTime(beginTime,endTime);
		
		if(proRisk==null){
			itemsReg.append("[]");
			riskRatioReg.append("[]");
			return SUCCESS;
		}else{
		Iterator<String> iter2 = proRisk.keySet().iterator();
		itemsPro.append("[");
		riskRatioPro.append("[");
		while(iter2.hasNext()){
			String key=iter2.next();
			itemsPro.append("\""+key+"\""+",");
			int v=proRisk.get(key);
			riskRatioPro.append(v+",");
		}
		itemsPro.append("]");
		riskRatioPro.append("]");
		
		return SUCCESS;
		}
	}
	
}
