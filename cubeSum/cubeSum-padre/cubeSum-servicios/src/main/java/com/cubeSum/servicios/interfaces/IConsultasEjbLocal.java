package com.cubeSum.servicios.interfaces;

import javax.ejb.Local;

import com.cubeSum.dto.CoordenadaDTO;
import com.cubeSum.dto.DatosConsultaValorInDTO;
import com.cubeSum.dto.ResultadoDTO;
import com.cubeSum.dto.ResultadoSumCubeDTO;

/**
 * Expone los métodos del EJB ConsultasEJB
 * 
 * @author Johnny Soto
 *
 */
@Local
public interface IConsultasEjbLocal {

	/**
	 * Actualiza una coordenada en el sistema.
	 * 
	 * @param personaDTO
	 * @return
	 */
	public ResultadoDTO actualizarCoordenada(CoordenadaDTO coordenada);

	/**
	 * Consulta el valor resultante de la consulta sumatoria de las coordenadas.
	 * 
	 * @param personaDTO
	 * @return
	 */
	public ResultadoSumCubeDTO consultarValoresRango(DatosConsultaValorInDTO coordenadaDTO);

}
