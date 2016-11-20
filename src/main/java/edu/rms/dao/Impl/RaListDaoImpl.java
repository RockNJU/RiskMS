package edu.rms.dao.Impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.rms.dao.BaseDao;
import edu.rms.dao.RaListDao;
import edu.rms.model.RaItems;
import edu.rms.model.RaList;
import edu.rms.model.RiskItem;
import edu.rms.model.RiskStateTrack;

@Repository
public class RaListDaoImpl implements RaListDao {

	
	@Autowired
	private BaseDao baseDao;
	
	
	@Override
	public List<RaList> getAll() {	
		try {
			List ls=baseDao.getAllList(RaList.class);
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public String save(RaList ra) {
		
		try {
			int size=baseDao.getAllList(RaList.class).size();
			if(size==0){
				ra.setRa_id(size+1);
			}else{
				Session session = baseDao.getNewSession();
				String hql = "from edu.rms.model.RaList as r order by ra_id desc";
				Query query=session.createQuery(hql);
				List<RaList> ms=query.list();
				session.flush();
				session.clear();
				session.close();
				if(ms.isEmpty())return null;
				else{
					ra.setRa_id(ms.get(0).getRa_id()+1);
				}
				
			}
			baseDao.save(ra);
			return "success";
		}catch (Exception e) {			
			e.printStackTrace();
			return "计划新增失败";
		}
	}
	@Override
	public String delete(int raid) {
		
		try {
			Session session = baseDao.getNewSession();
			
			String hql = "delete from edu.rms.model.RaList where ra_id = '"+raid+"'";
			Query query=session.createQuery(hql);
			session.flush();
			session.clear();
			session.close();
			
			return "success";
		}catch (Exception e) {			
			e.printStackTrace();	
			return "false";
		}
		
	}


	@Override
	public RaList getRAbyId(int id) {
		try {
			Session session = baseDao.getNewSession();
			String hql = "from edu.rms.model.RaList as r where r.ra_id = '"+id+"'";
			Query query=session.createQuery(hql);
			List<RaList> ms=query.list();
			session.flush();
			session.clear();
			session.close();
			if(ms.isEmpty())return null;
			return ms.get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public void update(RaList risk) {
		// TODO Auto-generated method stub
		try {
			baseDao.update(risk);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
