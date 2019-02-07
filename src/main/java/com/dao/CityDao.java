package com.dao;

import java.util.List;

import com.entity.City;

public interface CityDao {
	public boolean saveOrUpdate(City city);
	public List<City> list();
	public boolean delete(City city);
	public  List<City> getByName(String colName, String colValue);
    public City getObject(long id);

}
