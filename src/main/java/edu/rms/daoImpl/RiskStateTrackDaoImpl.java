package edu.rms.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.rms.dao.BaseDao;
import edu.rms.dao.RiskStateTrackDao;
import edu.rms.model.RaList;
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
			String hql = "from edu.rms.model.RiskStateTrack as r where r.riskItemId = '"+riskItemId+"'";
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
			int size=baseDao.getAllList(RiskStateTrack.class).size();
			riskStateTrack.setRiskStateTrack_id(size+1);;
			baseDao.save(riskStateTrack);
			return "新增成功";
		}catch (Exception e) {			
			e.printStackTrace();
			return "新增失败";
		}
	}

}
