package edu.rms.dao;

import java.util.List;

import edu.rms.model.RiskStateTrack;

public interface RiskStateTrackDao {

	public List<RiskStateTrack> getOneRiskAllStates(int riskItemId);
	
	public String save(RiskStateTrack riskStateTrack);
	
	public List<String> getRecTimes(String time1,String time2);
	
	public List<String> getRecTimesNoTime();
	
	public List<String> getProblemTimes(String time1,String time2);
	
	public List<String> getProblemNoTime();

	public RiskStateTrack getStateTrackById(int trackid);
}
