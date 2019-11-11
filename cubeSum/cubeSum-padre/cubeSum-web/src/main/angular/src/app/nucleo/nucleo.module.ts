import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { CapaComponent } from './capa/capa.component';
import { PrincipalComponent } from './capa/principal/principal.component';
import { FormsModule } from '@angular/forms';
import { GestionComponent } from './capa/principal/gestion/gestion.component';
import { ResultadosComponent } from './capa/principal/gestion/resultados/resultados.component';
import { ActualizarComponent } from './capa/principal/gestion/actualizar/actualizar.component';
import { CuboService } from './servicios/cubo-servicio/cubo.service'

//Nucleo representa al modulo que va a contener los componentes que van a orquestar la aplicacion 
//Debe ser importado en el componente principal AppModule
@NgModule({
  declarations: [CapaComponent, PrincipalComponent, GestionComponent, ResultadosComponent, ActualizarComponent],
  imports: [
    CommonModule, RouterModule, FormsModule
  ],
  exports: [
    CapaComponent
  ],
  providers: [
    CuboService
  ]
})
export class NucleoModule { }
