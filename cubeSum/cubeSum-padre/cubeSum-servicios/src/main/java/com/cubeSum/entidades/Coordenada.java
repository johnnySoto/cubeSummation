package com.cubeSum.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.cubeSum.dto.CoordenadaDTO;

/**
 * 
 */
@Entity
@Table(name = "CORDENADA")
@SequenceGenerator(name = "SEQ", sequenceName = "SEQ_COMUN", initialValue = 0, allocationSize = 1)
public class Coordenada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "SEQ")
	@Column(name = "ID_CORDENADA")
	private Long idCordenada;

	@Column(name = "PUNTO_X")
	private Long puntoX;

	@Column(name = "PUNTO_Y")
	private Long puntoY;

	@Column(name = "PUNTO_Z")
	private Long puntoZ;

	@Column(name = "VALOR")
	private BigDecimal valor;
	
	

	public Coordenada() {
		super();
	}

	/**
	 * Método que obtiene el valor de la propiedad idCordenada
	 * 
	 * @return the idCordenada
	 */
	public Long getIdCordenada() {
		return idCordenada;
	}

	/**
	 * Constructor de la clase.
	 * 
	 * @param puntoX
	 * @param puntoY
	 * @param puntoZ
	 */
	public Coordenada(CoordenadaDTO dto) {
		puntoX = dto.getPuntoX();
		puntoY = dto.getPuntoY();
		puntoZ = dto.getPuntoZ();
	}

	/**
	 * Método que asigna el valor de la propiedad idCordenada
	 * 
	 * @param idCordenada the idCordenada to set
	 */
	public void setIdCordenada(Long idCordenada) {
		this.idCordenada = idCordenada;
	}

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
