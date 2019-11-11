package com.cubeSum.dto;

import java.io.Serializable;
//import org.codehaus.jackson.map.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Objeto de transferencia que contiene los atributos necesarios para la
 * consulta de la sumatoria de los valores de un rango de coordenadas.
 * 
 * @author Johnny Soto
 *
 */
public class DatosConsultaValorInDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Atributo que contiene la coordenada en X
	 */
	private Long puntoXUno;

	/**
	 * Atributo que contiene la coordenada en Y
	 */
	private Long puntoYUno;

	/**
	 * Atributo que contiene la coordenada en Z
	 */
	private Long puntoZUno;

	/**
	 * Atributo que contiene la coordenada en X
	 */
	private Long puntoXDos;

	/**
	 * Atributo que contiene la coordenada en Y
	 */
	private Long puntoYDos;

	/**
	 * Atributo que contiene la coordenada en Z
	 */
	private Long puntoZDos;

	/**
	 * Método que obtiene el valor de la propiedad puntoXUno
	 * 
	 * @return the puntoXUno
	 */
	public Long getPuntoXUno() {
		return puntoXUno;
	}

	/**
	 * Método que asigna el valor de la propiedad puntoXUno
	 * 
	 * @param puntoXUno the puntoXUno to set
	 */
	public void setPuntoXUno(Long puntoXUno) {
		this.puntoXUno = puntoXUno;
	}

	/**
	 * Método que obtiene el valor de la propiedad puntoYUno
	 * 
	 * @return the puntoYUno
	 */
	public Long getPuntoYUno() {
		return puntoYUno;
	}

	/**
	 * Método que asigna el valor de la propiedad puntoYUno
	 * 
	 * @param puntoYUno the puntoYUno to set
	 */
	public void setPuntoYUno(Long puntoYUno) {
		this.puntoYUno = puntoYUno;
	}

	/**
	 * Método que obtiene el valor de la propiedad puntoZUno
	 * 
	 * @return the puntoZUno
	 */
	public Long getPuntoZUno() {
		return puntoZUno;
	}

	/**
	 * Método que asigna el valor de la propiedad puntoZUno
	 * 
	 * @param puntoZUno the puntoZUno to set
	 */
	public void setPuntoZUno(Long puntoZUno) {
		this.puntoZUno = puntoZUno;
	}

	/**
	 * Método que obtiene el valor de la propiedad puntoXDos
	 * 
	 * @return the puntoXDos
	 */
	public Long getPuntoXDos() {
		return puntoXDos;
	}

	/**
	 * Método que asigna el valor de la propiedad puntoXDos
	 * 
	 * @param puntoXDos the puntoXDos to set
	 */
	public void setPuntoXDos(Long puntoXDos) {
		this.puntoXDos = puntoXDos;
	}

	/**
	 * Método que obtiene el valor de la propiedad puntoYDos
	 * 
	 * @return the puntoYDos
	 */
	public Long getPuntoYDos() {
		return puntoYDos;
	}

	/**
	 * Método que asigna el valor de la propiedad puntoYDos
	 * 
	 * @param puntoYDos the puntoYDos to set
	 */
	public void setPuntoYDos(Long puntoYDos) {
		this.puntoYDos = puntoYDos;
	}

	/**
	 * Método que obtiene el valor de la propiedad puntoZDos
	 * 
	 * @return the puntoZDos
	 */
	public Long getPuntoZDos() {
		return puntoZDos;
	}

	/**
	 * Método que asigna el valor de la propiedad puntoZDos
	 * 
	 * @param puntoZDos the puntoZDos to set
	 */
	public void setPuntoZDos(Long puntoZDos) {
		this.puntoZDos = puntoZDos;
	}

	/**
	 * Método encargado de realizar la conversion del valor JSON al objeto concreto.
	 * 
	 * @author Johnny Soto
	 * @param arg Cadena json.
	 * @return Nueva instancia con valores ingresados.
	 * @throws Exception
	 */
	public static DatosConsultaValorInDTO valueOf(String arg) throws Exception {
		DatosConsultaValorInDTO instance = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			instance = mapper.readValue(arg, DatosConsultaValorInDTO.class);
			return instance;
		} catch (Exception e) {
			String mensaje = "Error convirtiendo el objeto JSON";
			throw new Exception(mensaje, e);
		}
	}

}
