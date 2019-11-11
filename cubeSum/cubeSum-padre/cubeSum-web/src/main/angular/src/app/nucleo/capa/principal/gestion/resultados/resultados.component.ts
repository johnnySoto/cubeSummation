import { Component, OnInit } from '@angular/core';

import { CuboService } from '../../../../../nucleo/servicios/cubo-servicio/cubo.service'
import { DatosConsultaValorInDTO } from '../../modelo/datosConsultaValorInDTO';
import { ResultadoSumCubeDTO } from '../../modelo/resultadoSumCubeDTO';

@Component({
	selector: 'app-resultados',
	templateUrl: './resultados.component.html'
})
export class ResultadosComponent implements OnInit {

	public datosConsultaValorInDTO: DatosConsultaValorInDTO = {
		puntoXUno: 1, puntoYUno: 1, puntoZUno: 1,
		puntoXDos: 2, puntoYDos: 2, puntoZDos: 2
	};
	public resultado: ResultadoSumCubeDTO;
	public prueba = 'valor';

	constructor(private cuboService: CuboService) { }

	ngOnInit() {
	}

	public consultarSuma() {
		this.cuboService.consultarValoresRango(this.datosConsultaValorInDTO).subscribe(
			resultados => {
				this.resultado = resultados;
			},
			error => {
				console.log(error);
			}
		);
		console.log('resultado servicio.... ' + this.resultado)
	}

}

