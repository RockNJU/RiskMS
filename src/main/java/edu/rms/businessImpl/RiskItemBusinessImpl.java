package edu.rms.businessImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rms.business.RiskItemBusiness;
import edu.rms.dao.RiskItemDao;
import edu.rms.dao.UserDao;
import edu.rms.model.RiskItem;


@Service
public class RiskItemBusinessImpl implements RiskItemBusiness{
	@Autowired
	private RiskItemDao riskItemDao;
	private UserDao udao;
	
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
		re=null;
		String tr="";
		String[] trs=null;
		for(int i=0;i<temp.size();i++){
			tr=temp.get(i).getTracker_id();
			trs=tr.split(";");
			for(int j=0;j<trs.length;j++){
				if(trs[j].equals(userid)){
					re.add(temp.get(i));
				}
			}
		}
		return re;
	}

}
