package com.rms.daoImpl;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.dao.BaseDao;
import com.rms.dao.UserDao;
import com.rms.model.User;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private BaseDao baseDao;
	

	@Override
	public String save(User user) {
		try {
			baseDao.save(user);
			return "新增用户成功";
		}catch (Exception e) {			
			e.printStackTrace();
			return "用户新增失败";
		}
	}

	
	public User findByName(String value)
	{
		try {
			Session session = baseDao.getNewSession();
			String hql = "from model.User as u where u.user_name = '"+value+"'";
			Query query=session.createQuery(hql);
			List<User> ms=query.list();
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
	public User getById(Long user_id) {
		try {
			Session session = baseDao.getNewSession();
			User mem=(User) session.get(User.class, user_id);
			session.flush();
			session.clear();
			session.close();
			return mem;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return baseDao.getAllList(User.class);
	}


}
