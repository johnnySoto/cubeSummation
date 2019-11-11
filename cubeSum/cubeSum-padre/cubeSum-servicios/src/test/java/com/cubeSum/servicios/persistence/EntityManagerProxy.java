package com.cubeSum.servicios.persistence;

import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.FlushModeType;
import javax.persistence.LockModeType;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.metamodel.Metamodel;

/**
 * Este proxy retrasa la creación del EntityManager hasta su primer uso.
 *
 * @author Johnny Soto
 * @version 1.0
 */
public class EntityManagerProxy implements EntityManager {

	private EntityManager delegate;
	private EntityManagerFactory factory;

	public EntityManagerProxy(EntityManagerFactory factory) {
		if (factory == null) {
			throw new IllegalArgumentException("La fabrica de entityManager no puede ser nula.");
		}
		this.factory = factory;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void persist(Object entity) {
		checkDelegateIsCreated();
		delegate.persist(entity);
		flush();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public <T> T merge(T entity) {
		checkDelegateIsCreated();
		T object = delegate.merge(entity);
		flush();
		return object;
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void remove(Object entity) {
		checkDelegateIsCreated();
		delegate.remove(entity);
		flush();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey) {
		checkDelegateIsCreated();
		return delegate.find(entityClass, primaryKey);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey, Map<String, Object> properties) {
		checkDelegateIsCreated();
		return delegate.find(entityClass, primaryKey, properties);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode) {
		checkDelegateIsCreated();
		return delegate.find(entityClass, primaryKey, lockMode);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public <T> T find(Class<T> entityClass, Object primaryKey, LockModeType lockMode, Map<String, Object> properties) {
		checkDelegateIsCreated();
		return delegate.find(entityClass, primaryKey, lockMode, properties);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public <T> T getReference(Class<T> entityClass, Object primaryKey) {
		checkDelegateIsCreated();
		return delegate.getReference(entityClass, primaryKey);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void flush() {
		checkDelegateIsCreated();
		delegate.flush();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void setFlushMode(FlushModeType flushMode) {
		checkDelegateIsCreated();
		delegate.setFlushMode(flushMode);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public FlushModeType getFlushMode() {
		checkDelegateIsCreated();
		return delegate.getFlushMode();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void lock(Object entity, LockModeType lockMode) {
		checkDelegateIsCreated();
		delegate.lock(entity, lockMode);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void lock(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		checkDelegateIsCreated();
		delegate.lock(entity, lockMode, properties);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void refresh(Object entity) {
		checkDelegateIsCreated();
		delegate.refresh(entity);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void refresh(Object entity, Map<String, Object> properties) {
		checkDelegateIsCreated();
		delegate.refresh(entity, properties);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void refresh(Object entity, LockModeType lockMode) {
		checkDelegateIsCreated();
		delegate.refresh(entity, lockMode);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void refresh(Object entity, LockModeType lockMode, Map<String, Object> properties) {
		checkDelegateIsCreated();
		delegate.refresh(entity, lockMode, properties);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void clear() {
		checkDelegateIsCreated();
		delegate.clear();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void detach(Object entity) {
		checkDelegateIsCreated();
//        delegate.detach(entity);
//        flush();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public boolean contains(Object entity) {
		checkDelegateIsCreated();
		return delegate.contains(entity);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public LockModeType getLockMode(Object entity) {
		checkDelegateIsCreated();
		return delegate.getLockMode(entity);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void setProperty(String propertyName, Object value) {
		checkDelegateIsCreated();
		delegate.setProperty(propertyName, value);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public Map<String, Object> getProperties() {
		checkDelegateIsCreated();
		return delegate.getProperties();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public Query createQuery(String qlString) {
		checkDelegateIsCreated();
		return delegate.createQuery(qlString);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public <T> TypedQuery<T> createQuery(CriteriaQuery<T> criteriaQuery) {
		checkDelegateIsCreated();
		return delegate.createQuery(criteriaQuery);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public <T> TypedQuery<T> createQuery(String qlString, Class<T> resultClass) {
		checkDelegateIsCreated();
		return delegate.createQuery(qlString, resultClass);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public Query createNamedQuery(String name) {
		checkDelegateIsCreated();
		return delegate.createNamedQuery(name);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public <T> TypedQuery<T> createNamedQuery(String name, Class<T> resultClass) {
		checkDelegateIsCreated();
		return delegate.createNamedQuery(name, resultClass);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public Query createNativeQuery(String sqlString) {
		checkDelegateIsCreated();
		return delegate.createNativeQuery(sqlString);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public Query createNativeQuery(String sqlString, Class resultClass) {
		checkDelegateIsCreated();
		return delegate.createNativeQuery(sqlString, resultClass);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public Query createNativeQuery(String sqlString, String resultSetMapping) {
		checkDelegateIsCreated();
		return delegate.createNativeQuery(sqlString, resultSetMapping);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void joinTransaction() {
		checkDelegateIsCreated();
		delegate.joinTransaction();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public <T> T unwrap(Class<T> cls) {
		checkDelegateIsCreated();
		return delegate.unwrap(cls);
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public Object getDelegate() {
		checkDelegateIsCreated();
		return delegate.getDelegate();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public void close() {
		checkDelegateIsCreated();
		delegate.close();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public boolean isOpen() {
		checkDelegateIsCreated();
		return delegate.isOpen();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public EntityTransaction getTransaction() {
		checkDelegateIsCreated();
		return delegate.getTransaction();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		checkDelegateIsCreated();
		return delegate.getEntityManagerFactory();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public CriteriaBuilder getCriteriaBuilder() {
		checkDelegateIsCreated();
		return delegate.getCriteriaBuilder();
	}

	/**
	 * {@inheritDoc }
	 */
	@Override
	public Metamodel getMetamodel() {
		checkDelegateIsCreated();
		return delegate.getMetamodel();
	}

	private void checkDelegateIsCreated() {
		if (delegate == null) {
			delegate = factory.createEntityManager();
		}
		assert (delegate != null) : "La f\u00E1brica cre\u00F3 un entityManager nulo";
	}
}
