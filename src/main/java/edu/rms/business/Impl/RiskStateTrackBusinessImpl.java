package edu.rms.business.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.rms.business.RiskStateTrackBusiness;
import edu.rms.dao.RiskStateTrackDao;
import edu.rms.model.RiskStateTrack;

@Service
public class RiskStateTrackBusinessImpl implements RiskStateTrackBusiness{

	@Autowired
	private RiskStateTrackDao rDao;
	
	@Override
	public String save(RiskStateTrack r) {
		
		return rDao.save(r);
	}

	@Override
	public List<RiskStateTrack> getOneRiskAllStates(int riskItemId) {
		
		return rDao.getOneRiskAllStates(riskItemId);
	}

	@Override
	public List<String> getRecTimes(String time1, String time2) {
		
		return rDao.getRecTimes(time1, time2);
	}

	@Override
	public List<String> getProblemTimes(String time1, String time2) {
		
		return rDao.getProblemTimes(time1, time2);
	}

	@Override
	public RiskStateTrack getStateTrackById(int trackid) {
		
		return rDao.getStateTrackById(trackid);
	}

	@Override
	public List<String> getRecTimesNoTime() {
		
		return rDao.getRecTimesNoTime();
	}

	@Override
	public List<String> getProblemTimesNoTime() {
		return rDao.getProblemNoTime();
	}

}
