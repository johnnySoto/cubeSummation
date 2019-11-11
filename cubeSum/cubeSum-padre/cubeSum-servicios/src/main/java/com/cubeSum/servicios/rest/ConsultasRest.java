package com.cubeSum.servicios.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.cubeSum.dto.CoordenadaDTO;
import com.cubeSum.dto.DatosConsultaValorInDTO;
import com.cubeSum.dto.ResultadoDTO;
import com.cubeSum.dto.ResultadoSumCubeDTO;
import com.cubeSum.servicios.interfaces.IConsultasEjbLocal;

/**
 * Componente que expone servicios rest.
 * 
 * @author Johnny Soto
 *
 */
@Path("/ConsultasRest")
public class ConsultasRest {

	@EJB
	private IConsultasEjbLocal consultaEJB;

	/**
	 * Actualiza / Crea una coordenada ingresada.
	 * 
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/actualizarCoordenada")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO actualizarCoordenada(CoordenadaDTO coordenada) {
		return consultaEJB.actualizarCoordenada(coordenada);
	}

	/**
	 * Consulta la suma resultante entre las coordenadas ingresadas.
	 * 
	 * @param persona
	 * @return
	 */
	@GET
	@Path("/consultarValoresRango")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoSumCubeDTO consultarValoresRango(@QueryParam("inDTO") DatosConsultaValorInDTO inDTO) {
		return consultaEJB.consultarValoresRango(inDTO);
	}
}
