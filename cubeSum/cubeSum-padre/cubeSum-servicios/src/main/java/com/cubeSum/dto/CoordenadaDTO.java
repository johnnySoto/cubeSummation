package com.cubeSum.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Objeto de transferencia que mapea los atributos de la entidad Coordenada
 * 
 * @author Johnny Soto
 *
 */
public class CoordenadaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que contiene la coordenada en X
	 */
	private Long puntoX;

	/**
	 * Atributo que contiene la coordenada en Y
	 */
	private Long puntoY;

	/**
	 * Atributo que contiene la coordenada en Z
	 */
	private Long puntoZ;

	/**
	 * Atributo que contiene el valor de la coordenada.
	 */
	private BigDecimal valor;

	/**
	 * Método que obtiene el valor de la propiedad puntoX
	 * 
	 * @return the puntoX
	 */
	public Long getPuntoX() {
		return puntoX;
	}

	/**
	 * Método que asigna el valor de la propiedad puntoX
	 * 
	 * @param puntoX the puntoX to set
	 */
	public void setPuntoX(Long puntoX) {
		this.puntoX = puntoX;
	}

	/**
	 * Método que obtiene el valor de la propiedad puntoY
	 * 
	 * @return the puntoY
	 */
	public Long getPuntoY() {
		return puntoY;
	}

	/**
	 * Método que asigna el valor de la propiedad puntoY
	 * 
	 * @param puntoY the puntoY to set
	 */
	public void setPuntoY(Long puntoY) {
		this.puntoY = puntoY;
	}

	/**
	 * Método que obtiene el valor de la propiedad puntoZ
	 * 
	 * @return the puntoZ
	 */
	public Long getPuntoZ() {
		return puntoZ;
	}

	/**
	 * Método que asigna el valor de la propiedad puntoZ
	 * 
	 * @param puntoZ the puntoZ to set
	 */
	public void setPuntoZ(Long puntoZ) {
		this.puntoZ = puntoZ;
	}

	/**
	 * Método que obtiene el valor de la propiedad valor
	 * 
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * Método que asigna el valor de la propiedad valor
	 * 
	 * @param valor the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
