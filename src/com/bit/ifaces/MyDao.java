package com.bit.ifaces;

import java.io.Serializable;
import java.util.List;

public interface MyDao<T> {
	public Object add(T t);
	public T find(Object obj);
	public List<T> findAll(Serializable t);
	public T update(T obj);
	public boolean delete(Object obj);
}
