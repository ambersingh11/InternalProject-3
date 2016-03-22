package com.bit.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bit.entity.Admin;
import com.bit.ifaces.MyDao;

public class AdminDao extends HibernateDaoSupport implements MyDao<Admin>{

	@Override
	public Object add(Admin t) {
		return getHibernateTemplate().save(t);
	}

	@Override
	public Admin find(Object obj) {
		Admin admin=(Admin)getHibernateTemplate().get(Admin.class,obj.toString());
		return admin;
	}

	@Override
	public List<Admin> findAll(Serializable t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Admin update(Admin obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

}
