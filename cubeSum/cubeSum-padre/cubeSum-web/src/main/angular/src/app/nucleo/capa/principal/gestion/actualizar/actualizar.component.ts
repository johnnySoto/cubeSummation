import { Component,  OnInit } from '@angular/core';

import { CuboService } from '../../../../../nucleo/servicios/cubo-servicio/cubo.service'
import { CoordenadaDTO } from '../../modelo/coordenadaDTO';
import { ResultadoDTO } from '../../modelo/resultadoDTO';

@Component({
	selector: 'app-actualizar',
	templateUrl: './actualizar.component.html'
})
export class ActualizarComponent implements OnInit {

	public coordenada: CoordenadaDTO = {puntoX: 1, puntoY: 1, puntoZ: 1, valor: 10};
	public resultado: ResultadoDTO;

	constructor(private cuboService: CuboService) { }

	ngOnInit() {
	}

	public actualizarCoordenada() {
		this.cuboService.actualizarCoordenada(this.coordenada).subscribe(
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

