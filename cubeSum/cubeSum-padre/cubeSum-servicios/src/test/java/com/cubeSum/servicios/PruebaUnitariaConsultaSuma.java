package com.cubeSum.servicios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import com.cubeSum.dto.CoordenadaDTO;
import com.cubeSum.dto.DatosConsultaValorInDTO;
import com.cubeSum.dto.ResultadoSumCubeDTO;
import com.cubeSum.servicios.ejb.ConsultasEJB;
import com.cubeSum.servicios.util.ComunUnitarias;

/**
 * Clase de prueba para la consulta de la suma de las coordenadas, dadas para la
 * consulta.
 * 
 */
public class PruebaUnitariaConsultaSuma extends ComunUnitarias {

	/**
	 * Prueba para la consulta de la suma de las coordenadas, dadas para la
	 * consulta.
	 * 
	 * @throws Exception
	 */
	@Test
	public void consultaSumaCubo() throws Exception {
		ConsultasEJB consultasBean = obtenerInstanciaEJB(ConsultasEJB.class.getCanonicalName());

		actualizarCoordenada(consultasBean, 1L, 1L, 1L, BigDecimal.ONE);
		actualizarCoordenada(consultasBean, 1L, 1L, 2L, BigDecimal.ONE);
		actualizarCoordenada(consultasBean, 1L, 2L, 1L, BigDecimal.ONE);
		actualizarCoordenada(consultasBean, 1L, 2L, 2L, BigDecimal.ONE);

		DatosConsultaValorInDTO consultaInDTO = new DatosConsultaValorInDTO();
		consultaInDTO.setPuntoXUno(1L);
		consultaInDTO.setPuntoYUno(1L);
		consultaInDTO.setPuntoZUno(1L);
		consultaInDTO.setPuntoXDos(1L);
		consultaInDTO.setPuntoYDos(2L);
		consultaInDTO.setPuntoZDos(2L);
		ResultadoSumCubeDTO resultado = consultasBean.consultarValoresRango(consultaInDTO);
		// Verifica que el mensaje sea el indicado
		assertEquals("Consulta exitosa", resultado.getMensajeEjecucion());
		// Verifica que el resultado sea exitoso
		assertTrue(resultado.isExitoso());
		// Verifica el valor resultante
		assertEquals(BigDecimal.valueOf(4), resultado.getMensajeEjecucion());

	}

	/**
	 * Método encargado de actualizar una coordenada.
	 * 
	 * @param consultasBean
	 * @param x
	 * @param y
	 * @param z
	 * @param valor
	 * @throws Exception
	 */
	private void actualizarCoordenada(ConsultasEJB consultasBean, Long x, Long y, Long z, BigDecimal valor)
			throws Exception {
		CoordenadaDTO coordenadaDTO = new CoordenadaDTO();
		coordenadaDTO.setPuntoX(x);
		coordenadaDTO.setPuntoY(y);
		coordenadaDTO.setPuntoZ(z);
		coordenadaDTO.setValor(valor);
		consultasBean.actualizarCoordenada(coordenadaDTO);
	}

}
