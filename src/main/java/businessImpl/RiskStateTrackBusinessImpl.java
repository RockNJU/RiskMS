package businessImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import business.RiskStateTrackBusiness;
import dao.RiskStateTrackDao;
import model.RiskStateTrack;

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

}
