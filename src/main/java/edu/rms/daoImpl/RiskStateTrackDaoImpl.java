package edu.rms.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.rms.dao.BaseDao;
import edu.rms.dao.RiskStateTrackDao;
import edu.rms.model.RiskStateTrack;
import edu.rms.model.User;

@Repository
public class RiskStateTrackDaoImpl implements RiskStateTrackDao{
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public List<RiskStateTrack> getOneRiskAllStates(int riskItemId) {
		try {
			Session session = baseDao.getNewSession();
			String hql = "from model.RiskStateTrack as r where r.riskItemId = '"+riskItemId+"'";
			Query query=session.createQuery(hql);
			List<RiskStateTrack> ms=query.list();
			session.flush();
			session.clear();
			session.close();
			if(ms.isEmpty())return null;
			return ms;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public String save(RiskStateTrack riskStateTrack) {
		try {
			baseDao.save(riskStateTrack);
			return "新增风险状�?�成�?";
		}catch (Exception e) {			
			e.printStackTrace();
			return "风险状�?�新增失�?";
		}
	}

}
