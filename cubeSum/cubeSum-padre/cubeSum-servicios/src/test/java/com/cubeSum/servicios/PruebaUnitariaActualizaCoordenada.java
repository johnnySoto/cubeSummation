package com.cubeSum.servicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.cubeSum.dto.CoordenadaDTO;
import com.cubeSum.dto.ResultadoDTO;
import com.cubeSum.servicios.ejb.ConsultasEJB;
import com.cubeSum.servicios.util.ComunUnitarias;

/**
 * Clase de prueba para la actualización de una coordenada del cubo.
 * 
 */
public class PruebaUnitariaActualizaCoordenada extends ComunUnitarias {

	/**
	 * Crea o actualiza una coordenada.
	 * 
	 * @throws Exception
	 */
	@Test
	public void actualizarCoordenada() throws Exception {
		CoordenadaDTO coordenadaDTO = new CoordenadaDTO();
		coordenadaDTO.setPuntoX(1L);
		coordenadaDTO.setPuntoY(1L);
		coordenadaDTO.setPuntoZ(1L);
		coordenadaDTO.setValor(BigDecimal.ONE);
		// Obtiene la instancia del EJB.
		ConsultasEJB consultasBean = obtenerInstanciaEJB(ConsultasEJB.class.getCanonicalName());
		ResultadoDTO resultado = consultasBean.actualizarCoordenada(coordenadaDTO);
		assertNotNull(resultado);

		// Verifica que el resultado sea exitoso
		assertTrue(resultado.isExitoso());
		// Verifica que el mensaje sea el indicado
		assertEquals("Coordenada actualizada de forma exitosa", resultado.getMensajeEjecucion());
	}

}
