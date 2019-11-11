package com.cubeSum.servicios.ejb;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cubeSum.dto.CoordenadaDTO;
import com.cubeSum.dto.DatosConsultaValorInDTO;
import com.cubeSum.dto.ResultadoDTO;
import com.cubeSum.dto.ResultadoSumCubeDTO;
import com.cubeSum.entidades.Coordenada;
import com.cubeSum.servicios.interfaces.IConsultasEjbLocal;

/**
 * EJB de consultas
 */
@Stateless
public class ConsultasEJB implements IConsultasEjbLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Manejo de logs en el sistema.
	 */
	private final static Logger LOGGER = Logger.getLogger(ConsultasEJB.class.getCanonicalName());

	/**
	 * {@link com.cubeSum.servicios.interfaces.IConsultasEjbLocal#actualizarCoordenada(CoordenadaDTO)}
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO actualizarCoordenada(CoordenadaDTO coordenadaDTO) {
		try {
			Coordenada coordenada = buscarCoordenada(coordenadaDTO);
			coordenada.setValor(coordenadaDTO.getValor());
			if (coordenada.getIdCordenada() != null) {
				em.merge(coordenada);
			} else {
				em.persist(coordenada);
			}
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error al tratar de actualizar una coordenada {0}", e.getMessage());
			return new ResultadoDTO(false, e.getMessage());
		}
		return new ResultadoDTO(true, "Coordenada actualizada de forma exitosa");
	}

	/**
	 * {@link com.cubeSum.servicios.interfaces.IConsultasEjbLocal#consultarValoresRango(CoordenadaDTO)}
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ResultadoSumCubeDTO consultarValoresRango(DatosConsultaValorInDTO coordenadaDTO) {
		try {
			// Carga los parámetros para la ejecución de la consulta
			Map<String, Long> parametros = cargarParametrosConsulta(coordenadaDTO);

			Query consulta = em.createNativeQuery("SELECT SUM(VALOR) FROM("
					+ "SELECT * from Cordenada where punto_x <=:x2 MINUS SELECT * from Cordenada where punto_x =:x2 and punto_y >:y2"
					+ " MINUS SELECT * from Cordenada where punto_x =:x2 and punto_y =:y2 AND punto_z > :z2"
					+ " MINUS SELECT * from Cordenada where punto_x =:x1 and punto_y <:y1"
					+ " MINUS SELECT * from Cordenada where punto_x =:x1 and punto_y =:y1 AND punto_z < :z1)");

			for (Entry<String, Long> entry : parametros.entrySet()) {
				consulta.setParameter(entry.getKey(), entry.getValue());
			}

			BigDecimal valor = (BigDecimal) consulta.getSingleResult();
			return new ResultadoSumCubeDTO(true, "Consulta exitosa", valor);
		} catch (NoResultException e) {
			// En este bloque captura la excepción generada al no encontrar resultados
			LOGGER.log(Level.INFO, "No se encontraron coordenadas, retorna cero");
			return new ResultadoSumCubeDTO(true, "No se encontraron coordenadas, retorna cero", BigDecimal.ZERO);
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "Error al tratar de actualizar una coordenada {0}", e.getMessage());
			return new ResultadoSumCubeDTO(false, e.getMessage(), null);
		}
	}

	/**
	 * Método encargado de cargar en una mapa los valores usados para la consulta.
	 * 
	 * @param coordenadaDTO
	 * @return
	 */
	private Map<String, Long> cargarParametrosConsulta(DatosConsultaValorInDTO coordenadaDTO) {
		Map<String, Long> parametros = new HashMap<String, Long>();
		parametros.put("x1", coordenadaDTO.getPuntoXUno());
		parametros.put("y1", coordenadaDTO.getPuntoYUno());
		parametros.put("z1", coordenadaDTO.getPuntoZUno());
		parametros.put("x2", coordenadaDTO.getPuntoXDos());
		parametros.put("y2", coordenadaDTO.getPuntoYDos());
		parametros.put("z2", coordenadaDTO.getPuntoZDos());
		return parametros;
	}

	/**
	 * Método encargado de buscar mediante las coordenadas x, y, z. Una coordenada
	 * en BD, de no existir genera una nueva instancia.
	 * 
	 * @param coordenadaDTO
	 * @return
	 */
	private Coordenada buscarCoordenada(CoordenadaDTO coordenadaDTO) {
		try {
			return (Coordenada) em
					.createQuery(
							"Select coo FROM Coordenada coo where coo.puntoX =:X AND coo.puntoY =:Y AND coo.puntoZ =:Z")
					.setParameter("X", coordenadaDTO.getPuntoX()).setParameter("Y", coordenadaDTO.getPuntoY())
					.setParameter("Z", coordenadaDTO.getPuntoZ()).getSingleResult();
		} catch (NoResultException e) {
			LOGGER.log(Level.INFO, "No se encontró registro previo, se procede a crear un nuevo registro");
		}
		// Se invoca constructor con el dto, para generar una nueva instancia con los
		// datos básicos de la coordenada
		return new Coordenada(coordenadaDTO);
	}

}
