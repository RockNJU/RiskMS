package dao;

import java.util.List;

import model.RiskStateTrack;

public interface RiskStateTrackDao {

	public List<RiskStateTrack> getOneRiskAllStates(int riskItemId);
	
	public String save(RiskStateTrack riskStateTrack);
	
	
}
