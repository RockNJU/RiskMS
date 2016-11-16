package business;

import java.util.List;

import model.RiskStateTrack;

public interface RiskStateTrackBusiness {
	
	public String save(RiskStateTrack r);
	
	public List<RiskStateTrack> getOneRiskAllStates(int riskItemId);

	
}
