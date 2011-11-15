package it.trew.prove.model.dao;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import com.google.appengine.api.datastore.EntityNotFoundException;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.googlecode.objectify.util.DAOBase;

public class ObjectifyDao<T> extends DAOBase {
	
	private Class<T> clazz;
	
	/**
	* We’ve got to get the associated domain class somehow
	*
	* @param clazz
	*/
	protected ObjectifyDao(Class<T> clazz) {
		this.clazz = clazz;
	}
	
	public Key<T> add(T entity) {
		Key<T> key = ofy().put(entity);
		return key;
	}
	
	public void delete(T entity) {
		ofy().delete(entity);
	}
	
	public void delete(Key<T> entityKey) {
		ofy().delete(entityKey);
	}
	
	public T get(Key<T> key) throws EntityNotFoundException {
		T obj = ofy().get(key);
		return obj;
	}
	
	public T get(Long id) throws EntityNotFoundException {
		T obj = ofy().get(this.clazz, id);
		return obj;
	}
	
	public T get(String id) throws EntityNotFoundException	{
		T obj = ofy().get(this.clazz, id);
		return obj;
	}
	
	public Key<T> key(T entity) { 
        return ObjectifyService.factory().getKey(entity); 
	} 
	
	/**
	* Convenience method to get an object matching a single property
	*
	* @param propName
	* @param propValue
	* @return T matching Object
	*/
	public T getByProperty(String propName, Object propValue) {
		T result = ofy().
			query(this.clazz).
			filter(propName, propValue).
			get();	
		return result;
	}
	
	public List<T> list() {
		List<T> list = ofy().
			query(this.clazz).
			list();
		return list;
	}
	
	public List<T> listOrderBy(String fieldName, boolean ascendant) {		
		
		List<T> list = ofy().
			query(this.clazz).
			order((ascendant ? "" : "-")+fieldName).
			list();
		return list;
	}
	
	public int count() {
		return ofy().
			query(this.clazz).
			count();
	}
	
	public List<T> listByProperty(String propName, Object propValue) {
		List<T> list = ofy().
			query(this.clazz).
			filter(propName, propValue).
			list();
		return list;
	}
	
	public T getByExample(T u, String... matchProperties) {
		Query<T> q = ofy().query(this.clazz);
		// 	Find non-null properties and add to query
		for (String propName : matchProperties) {
			Object propValue = getPropertyValue(u, propName);
			q.filter(propName, propValue);
		}
		T obj = q.get();		
		return obj;
	}
	
	public List<T> listByExample(T u, String... matchProperties) {
		Query<T> q = ofy().query(this.clazz);
		// Find non-null properties and add to query
		for (String propName : matchProperties)	{
			Object propValue = getPropertyValue(u, propName);
			q.filter(propName, propValue);
		}
		List<T> list = q.list();
		return list;
	}	
	
	private Object getPropertyValue(Object obj, String propertyName) {
		
		BeanInfo beanInfo;
		try {
			beanInfo = Introspector.getBeanInfo(obj.getClass());
		}
		catch (IntrospectionException e) {
			throw new RuntimeException(e);
		}
		
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
			String propName = propertyDescriptor.getName();
			if (propName.equals(propertyName)) {
				Method readMethod = propertyDescriptor.getReadMethod();
				try {
					Object value = readMethod.invoke(obj, new Object[] {});
					return value;
				}
				catch (IllegalArgumentException e) {
					throw new RuntimeException(e);
				}
				catch (IllegalAccessException e) {
					throw new RuntimeException(e);
				}
				catch (InvocationTargetException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return null;
	}

}