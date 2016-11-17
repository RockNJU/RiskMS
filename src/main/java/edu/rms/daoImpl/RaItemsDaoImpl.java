package edu.rms.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.rms.dao.BaseDao;
import edu.rms.dao.RaItemsDao;
import edu.rms.model.RaItems;
import edu.rms.model.RiskStateTrack;


@Repository
public class RaItemsDaoImpl implements RaItemsDao{
	
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public List<RaItems> getOneRAItems(int raid) {
		
		try {
			Session session = baseDao.getNewSession();
			String hql = "from edu.rms.model.raList as r where r.ra_id = '"+raid+"'";
			Query query=session.createQuery(hql);
			List<RaItems> ms=query.list();
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
	public String save(RaItems ra) {
		
		try {
			baseDao.save(ra);
			return "SUCCESS";
		}catch (Exception e) {			
			e.printStackTrace();
			return "FALSE";
		}
	}

}
