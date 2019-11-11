package com.cubeSum.servicios.util;

import java.lang.reflect.Field;
import java.util.HashMap;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cubeSum.servicios.persistence.TestEntityManager;
import com.cubeSum.servicios.persistence.UncommitableEntityManager;

/**
 * Clase encargada de tener los métodos comunes para las pruebas unitarias.
 * 
 * @author Johnny Soto
 *
 */
public class ComunUnitarias {

	/**
	 * Método encargado de construir un EJB en modo prueba unitaria, con un contexto
	 * de persistencia acorde, que no realiza commit a la base de datos.
	 * 
	 * @param beanClassName
	 * @return
	 * @throws Exception
	 */
	protected <T> T obtenerInstanciaEJB(String beanClassName) throws Exception {
		T bean = null;
		try {
			Class<T> beanClass = (Class<T>) Class.forName(beanClassName);
			bean = beanClass.newInstance();
			Field[] campos = beanClass.getDeclaredFields();
			for (Field c : campos) {
				if (c.getType().equals(EntityManager.class)) {
					c.setAccessible(true);

					HashMap<String, String> properties = new HashMap<String, String>();
					properties.put("javax.persistence.transactionType", "RESOURCE_LOCAL");
					properties.put("hibernate.query.startup_check", "false");
					properties.put("hibernate.show_sql", "false");
					properties.put("hibernate.format_sql", "false");
					properties.put("hibernate.use_sql_comments", "false");
					properties.put("hibernate.generate_statistics", "false");
					EntityManagerFactory emf = Persistence.createEntityManagerFactory("semillero", properties);
					EntityManager em = new UncommitableEntityManager(emf);
					TestEntityManager testEm = TestEntityManager.getInstance();
					testEm.setEntityManager(em);
					c.set(bean, testEm);
				}
			}
		} catch (Exception e) {
			throw new Exception("No se pudo construir el EJB", e);
		}
		return bean;
	}

}
