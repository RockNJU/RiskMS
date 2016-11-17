package edu.rms.dao;

import java.util.List;

import edu.rms.model.RiskStateTrack;

public interface RiskStateTrackDao {

	public List<RiskStateTrack> getOneRiskAllStates(int riskItemId);
	
	public String save(RiskStateTrack riskStateTrack);
	
	
}
