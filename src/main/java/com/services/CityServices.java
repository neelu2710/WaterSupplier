package com.services;

import java.util.List;

import com.entity.City;

public interface CityServices {

	public boolean saveOrUpdate(City user);
	public List<City> list();
	public boolean delete(City user);
	public  List<City> getByName(String colName, String colValue);
	public City  getObject(long id);
}
