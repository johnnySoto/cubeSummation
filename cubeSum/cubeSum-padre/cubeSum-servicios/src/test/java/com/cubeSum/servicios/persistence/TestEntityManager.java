package com.cubeSum.servicios.persistence;

import javax.persistence.EntityManager;

/**
 * Clase encargada de almacenar y suministrar el EntityManager para los EJB que
 * se construyan en modo de pruebas.
 * 
 * @author Johnny Soto
 *
 */
public class TestEntityManager {

	/**
	 * Instancia única de la clase.
	 */
	private static final TestEntityManager INSTANCE = new TestEntityManager();

	/**
	 * EntityManager usado en los Test.
	 */
	private EntityManager entityManager;

	/**
	 * Constructor por defecto.
	 */
	public TestEntityManager() {
	}

	/**
	 * Retorna la instancia de la clase.
	 * 
	 * @return instancia única de la clase.
	 */
	public static TestEntityManager getInstance() {
		return INSTANCE;
	}

	/**
	 * Obtiene el EntityManager para realizar las pruebas.
	 * 
	 * @return EntityManager de los Test.
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Asigna un valor a <code>entityManager</code>
	 * 
	 * @param entityManager : nuevo valor del entityManager.
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
