import { Injectable, Injector } from '@angular/core';
import { Observable } from 'rxjs';
import { AbstractService } from '../template.service';
import { CoordenadaDTO } from '../../capa/principal/modelo/coordenadaDTO';
import { ResultadoSumCubeDTO } from '../../capa/principal/modelo/resultadoSumCubeDTO';
import { ResultadoDTO } from '../../capa/principal/modelo/resultadoDTO';
import { DatosConsultaValorInDTO } from '../../capa/principal/modelo/datosConsultaValorInDTO';

@Injectable({
  providedIn: 'root'
})
export class CuboService extends AbstractService {
	
  public coordenadaDTO: CoordenadaDTO;
  public resultadoSumCubeDTO: ResultadoSumCubeDTO;
  public resultadoDTO: ResultadoDTO;
  public datosConsultaValorInDTO: DatosConsultaValorInDTO;
  
  /**
   * Constructor
   */
  constructor(injector: Injector) {
    super(injector);
  }

   public consultarValoresRango(datosConsultaValorInDTO: DatosConsultaValorInDTO):  Observable<ResultadoSumCubeDTO> {
 	return this.get<ResultadoSumCubeDTO>("/cubeSum-servicios", "/ConsultasRest/consultarValoresRango",
	{
      });
 }

  public actualizarCoordenada(coordenadaDTO: CoordenadaDTO):  Observable<ResultadoDTO> {
 	return this.post<ResultadoDTO>("/cubeSum-servicios", "/ConsultasRest/actualizarCoordenada",
	{
      });
 }

}
