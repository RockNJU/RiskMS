package business;

import java.util.List;

import org.springframework.stereotype.Service;

import model.RiskStateTrack;
@Service
public interface RiskStateTrackBusiness {
	
	public String save(RiskStateTrack r);
	
	public List<RiskStateTrack> getOneRiskAllStates(int riskItemId);

	
}
