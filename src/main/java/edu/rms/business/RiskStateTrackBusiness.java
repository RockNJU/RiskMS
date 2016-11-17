package edu.rms.business;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.rms.model.RiskStateTrack;

public interface RiskStateTrackBusiness {
	
	public String save(RiskStateTrack r);
	
	public List<RiskStateTrack> getOneRiskAllStates(int riskItemId);

	
}
