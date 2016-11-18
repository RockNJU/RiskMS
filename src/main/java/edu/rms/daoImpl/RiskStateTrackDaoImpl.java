package edu.rms.daoImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
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
			String hql = "from edu.rms.model.RiskStateTrack as r where r.riskItemId = '"+riskItemId+" order by createTime desc'";
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
			riskStateTrack.setRiskStateTrack_id(size+1);
			riskStateTrack.setCreateTime(new Timestamp(System.currentTimeMillis()));
			baseDao.save(riskStateTrack);
			return "新增成功";
		}catch (Exception e) {			
			e.printStackTrace();
			return "新增失败";
		}
	}

	@Override
	public List<String> getRecTimes(String time1, String time2) {
		try {
			Session session = baseDao.getNewSession();
			
			String hql = "Select count(*) as num,riskitemId from riskstatetrack"+ 
                          "where createTime between '"+time1+"' and '"+time2+
                          "' and state = 0 group by riskitemId ORDER BY num DESC' ";
			Query query=session.createQuery(hql);
			List list=query.list();
			List<String> re=new ArrayList<String>();
			String temp="";
			for(int i = 0; i <list.size();i++) {
	             Object[] obj =(Object[])list.get(i);
	             String count = String.valueOf(obj[0]);
	             String riskitemid = String.valueOf(obj[1]);
	             temp = riskitemid+";"+count;
	             re.add(temp);
	        }	
			session.flush();
			session.clear();
			session.close();
			if(re.isEmpty())return null;
			return re;
		}catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<String> getProblemTimes(String time1, String time2) {
		try {
			Session session = baseDao.getNewSession();
			
			String hql = "Select count(*) as num,riskitemId from riskstatetrack"+ 
                          "where createTime between '"+time1+"' and '"+time2+
                          "' and state = 1 group by riskitemId ORDER BY num DESC' ";
			Query query=session.createQuery(hql);
			List list=query.list();
			List<String> re=new ArrayList<String>();
			String temp="";
			for(int i = 0; i <list.size();i++) {
	             Object[] obj =(Object[])list.get(i);
	             String count = String.valueOf(obj[0]);
	             String riskitemid = String.valueOf(obj[1]);
	             temp = riskitemid+";"+count;
	             re.add(temp);
	        }	
			session.flush();
			session.clear();
			session.close();
			if(re.isEmpty())return null;
			return re;
		}catch (Exception e) {			
			e.printStackTrace();
			return null;
		}
	}
	
	

}
