package edu.rms.business;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.rms.model.RiskStateTrack;

public interface RiskStateTrackBusiness {
	
	public String save(RiskStateTrack r);
	
	public List<RiskStateTrack> getOneRiskAllStates(int riskItemId);

	//获得的均是"riskitemid;次数"的形式
	public List<String> getRecTimes(String time1,String time2); 
	
	public List<String> getProblemTimes(String time1,String time2);

	public RiskStateTrack getStateTrackById(int trackid);
}
