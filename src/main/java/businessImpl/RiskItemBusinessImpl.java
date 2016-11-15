package businessImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import business.RiskItemBusiness;
import dao.RiskItemDao;
import model.RiskItem;


public class RiskItemBusinessImpl implements RiskItemBusiness{
	@Autowired
	private RiskItemDao riskItemDao;
	
	
	@Override
	public String addRiskItem(RiskItem riskItem) {
		return riskItemDao.save(riskItem);
	}

	@Override
	public List<RiskItem> getAllRiskItem() {
		
		return riskItemDao.getAll();
	}

	@Override
	public List<RiskItem> getMyRiskItem(Long userid) {
		List<RiskItem> temp=riskItemDao.getAll();
		List<RiskItem> re=new ArrayList<RiskItem>();
		re=null;
		String tr="";
		String[] trs=null;
		for(int i=0;i<temp.size();i++){
			tr=temp.get(i).getTriggers();
			trs=tr.split(",");
			for(int j=0;j<trs.length;j++){
				if(trs[j].equals(userid)){
					re.add(temp.get(i));
				}
			}
		}
		return re;
	}

}
