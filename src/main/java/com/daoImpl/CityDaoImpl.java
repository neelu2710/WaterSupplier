package com.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dao.CityDao;
import com.entity.City;

@Repository
@Transactional
public class CityDaoImpl implements CityDao{

	@Autowired
	SessionFactory session;
	public boolean saveOrUpdate(City user) {
		// TODO Auto-generated method stub
		session.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	public List<City> list() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from City").list();
	}

	public boolean delete(City user) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<City> getByName(String colName, String colValue) {
		//session.getCurrentSession().get
		return session.getCurrentSession().createCriteria(City.class).add(Restrictions.eq(colName, colValue)).list();
		//return null;
	}

	public City getObject(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
