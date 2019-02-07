package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CityDao;
import com.entity.City;
import com.services.CityServices;

@Service
public class CityServicesImpl implements CityServices{
	@Autowired
	CityDao userDao;
	public boolean saveOrUpdate(City user) {
		// TODO Auto-generated method stub
		
		return userDao.saveOrUpdate(user);
	}

	public List<City> list() {
		// TODO Auto-generated method stub
		return userDao.list();
	}

	public boolean delete(City user) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<City> getByName(String colName, String colValue) {
		return userDao.getByName(colName, colValue);
		//return 
	}

	public City getObject(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
