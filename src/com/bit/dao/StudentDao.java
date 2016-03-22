package com.bit.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.bit.entity.Student;
import com.bit.ifaces.MyDao;

public class StudentDao extends HibernateDaoSupport implements MyDao<Student> {

	@Override
	public Object add(Student t) {
		return getHibernateTemplate().save(t);
	}

	@Override
	public Student find(Object obj) {
		
		return null;
	}

	@Override
	public List<Student> findAll(Serializable t) {
		List<Student> list  = (List<Student>)getHibernateTemplate().find("from Student where department = ? ",t); 
		return list;
	}

	@Override
	public Student update(Student obj) {
		// TODO Auto-generated method stub
		return null;
	}
    
	@Override
	public boolean delete(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}
	public List<Student> findByCriteria(Serializable t){
		String hql="FROM Student S WHERE S.department='"+t+"' ORDER BY S.grade DESC";
		Query query = getSession().createQuery(hql);
		query.setMaxResults(3);
		
		List<Student> results = (List<Student>)query.list();
		return results;
	}

}
