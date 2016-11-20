package edu.rms.dao.Impl;

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
			String hql = "from edu.rms.model.RaItems as r where r.ra_id = '"+raid+"'";
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
			int size=baseDao.getAllList(RaItems.class).size();
			if(size==0){
				ra.setRaItems_id(size+1);
			}else{
				Session session = baseDao.getNewSession();
				String hql = "from edu.rms.model.RaItems as r order by raItems_id desc";
				Query query=session.createQuery(hql);
				List<RaItems> ms=query.list();
				session.flush();
				session.clear();
				session.close();
				if(ms.isEmpty())return null;
				else{
					ra.setRaItems_id(ms.get(0).getRaItems_id()+1);
				}
			}
			
			baseDao.save(ra);
			return "success";
		}catch (Exception e) {			
			e.printStackTrace();	
			return "false";
		}
		
	}

	@Override
	public String delete(int ra_id) {
		
		try {
            Session session = baseDao.getNewSession();
          
           
			String hql = "delete edu.rms.model.RaItems where ra_id = "+ra_id;
			Query query=session.createQuery(hql);
			
			query.executeUpdate();
			System.out.println("delete"+baseDao.getAllList(RaItems.class).size());
			session.flush();
			session.clear();
			session.close();
			
			return "success";
		}catch (Exception e) {			
			e.printStackTrace();	
			return "false";
		}
		
	}

}
