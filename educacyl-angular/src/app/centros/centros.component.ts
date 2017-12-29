import {Component, OnInit} from '@angular/core';
import {CentroService} from './centro.service';
import 'rxjs/add/operator/map';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-centros',
  template: `

    <div style="padding:20px">
      <h3>Listado de centros</h3>

      <app-selector-provincia (provinciaSeleccionada)="asignarProvincia($event)"></app-selector-provincia>
      <app-selector-municipio (municipioSeleccionado)="asignarMunicipio($event)" [provinciaId]="provinciaId"></app-selector-municipio>
      <app-selector-localidad (localidadSeleccionada)="asignarLocalidad($event)" [provinciaId]="provinciaId"
                              [municipioId]="municipioId"></app-selector-localidad>


      <div class="example-container mat-elevation-z8">
        <mat-table #table [dataSource]="dataSource">

          <ng-container matColumnDef="centroId">
            <mat-header-cell *matHeaderCellDef> Id</mat-header-cell>
            <mat-cell *matCellDef="let element"> {{element.centroId}}</mat-cell>
          </ng-container>

          <ng-container matColumnDef="nombre">
            <mat-header-cell *matHeaderCellDef> Nombre</mat-header-cell>
            <mat-cell *matCellDef="let element"> {{element.nombre}}</mat-cell>
          </ng-container>

          <mat-header-row *matHeaderRowDef="displayedColumns"></mat-header-row>
          <mat-row *matRowDef="let row; columns: displayedColumns;" (click)="cargarCentro(row)"></mat-row>
        </mat-table>
      </div>


    </div>
  `,
  styleUrls: ['./centros.component.css']
})
export class CentrosComponent implements OnInit {

  dataSource;
  provinciaId;
  municipioId;

  displayedColumns = ['centroId', 'nombre'];

  constructor(private centroService: CentroService) {
  }

  cargarCentro(row) {
  }

  ngOnInit() {
    this.centroService.getCentros().subscribe(this.paint());
  }

  paint() {
    return x => {
      this.dataSource = new MatTableDataSource<any>(x);
    };
  }

  asignarProvincia($event) {
    this.provinciaId = $event;
  }

  asignarMunicipio($event) {
    this.municipioId = $event;
  }

  asignarLocalidad($event) {
    this.centroService.getCentros($event.provinciaId, $event.municipioId, $event.localidadId)
      .subscribe(this.paint());
  }

}
