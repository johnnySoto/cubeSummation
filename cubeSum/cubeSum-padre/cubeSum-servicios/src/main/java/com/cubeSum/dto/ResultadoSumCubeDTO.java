package com.cubeSum.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Indica el resultado de ejecución de la consulta de la sumatoria de las
 * coordenadas.
 * 
 * @author Johnny Soto
 *
 */
public class ResultadoSumCubeDTO extends ResultadoDTO implements Serializable {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Indica el resultado de la operación de suma.
	 */
	private BigDecimal resultado;

	/**
	 * Constructor de la clase.
	 * 
	 * @param exitoso
	 * @param mensajeEjecucion
	 */
	public ResultadoSumCubeDTO(boolean exitoso, String mensajeEjecucion, BigDecimal resultado) {
		super(exitoso, mensajeEjecucion);
		this.resultado = resultado;
	}

	/**
	 * Método que obtiene el valor de la propiedad resultado
	 * 
	 * @return the resultado
	 */
	public BigDecimal getResultado() {
		return resultado;
	}

	/**
	 * Método que asigna el valor de la propiedad resultado
	 * 
	 * @param resultado the resultado to set
	 */
	public void setResultado(BigDecimal resultado) {
		this.resultado = resultado;
	}

}
