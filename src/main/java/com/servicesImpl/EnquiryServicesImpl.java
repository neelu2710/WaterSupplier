package com.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.EnquiryDao;
import com.entity.Enquiry;
import com.services.EnquiryServices;

@Service
public class EnquiryServicesImpl implements EnquiryServices{
	@Autowired
	EnquiryDao enquiryDao;
	public boolean saveOrUpdate(Enquiry user) {
		return enquiryDao.saveOrUpdate(user);
	}

	public List<Enquiry> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean delete(Enquiry user) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Enquiry> getByName(String colName, String colValue) {
		// TODO Auto-generated method stub
		return null;
	}

	public Enquiry getObject(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
