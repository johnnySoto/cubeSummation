package com.cubeSum.servicios.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

/**
 * Implementación de un entityManager que retorna transacciones sobre las cuales
 * la invocación del método {@link EntityTransaction#commit() } solo hará flush
 * de los cambios temporales en el {@link EntityManager}.
 *
 * @author Johnny Soto
 * @version 1.0
 */
public class UncommitableEntityManager extends EntityManagerProxy {

	public UncommitableEntityManager(EntityManagerFactory factory) {
		super(factory);
	}

	@Override
	public EntityTransaction getTransaction() {
		return new UncommitableTransaction(super.getTransaction(), this);
	}

	/**
	 * Implementa una transacción que no soporta commit.
	 */
	private class UncommitableTransaction implements EntityTransaction {

		private final EntityTransaction delegate;
		private final EntityManager entityManager;

		public UncommitableTransaction(EntityTransaction delegate, EntityManager entityManager) {
			this.delegate = delegate;
			this.entityManager = entityManager;
		}

		@Override
		public void begin() {
			delegate.begin();
		}

		@Override
		public void commit() {
			entityManager.flush();
		}

		@Override
		public void rollback() {
			delegate.rollback();
		}

		@Override
		public void setRollbackOnly() {
			delegate.setRollbackOnly();
		}

		@Override
		public boolean getRollbackOnly() {
			return delegate.getRollbackOnly();
		}

		@Override
		public boolean isActive() {
			return delegate.isActive();
		}
	}
}
