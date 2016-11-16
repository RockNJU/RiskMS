package business;

import java.util.List;

import org.springframework.stereotype.Service;

import model.RiskItem;


@Service
public interface RiskItemBusiness {
	
	
	public String addRiskItem(RiskItem riskItem);
	
	public List<RiskItem> getAllRiskItem();
	
	public List<RiskItem> getMyRiskItem(int userid);
}
