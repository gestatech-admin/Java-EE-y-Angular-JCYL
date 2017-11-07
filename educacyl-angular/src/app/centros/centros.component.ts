import {Component, OnInit} from '@angular/core';
import {CentroService} from '../centro.service';
import 'rxjs/add/operator/map';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-centros',
  template: `

    <div *ngFor="let alumno of alumnos$ | async">{{alumno.nombre}}</div>
    
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

        <ng-container matColumnDef="cursoId">
          <mat-header-cell *matHeaderCellDef> Curso Id</mat-header-cell>
          <mat-cell *matCellDef="let element"> {{element.cursoId}}</mat-cell>
        </ng-container>

        <mat-header-row *matHeaderRowDef="displayedColumns"></mat-header-row>
        <mat-row *matRowDef="let row; columns: displayedColumns;" (click)="cargarCentro(row)"></mat-row>
      </mat-table>
    </div>


  `,
  styleUrls: ['./centros.component.css']
})
export class CentrosComponent implements OnInit {

  alumnos$;

  dataSource;

  displayedColumns = ['centroId', 'nombre', 'cursoId'];

  constructor(private centroService: CentroService) {
  }

  cargarCentro(row) {
    this.alumnos$ = this.centroService.cargarAlumnos(row.centroId).map(x => x.json());
  }

  ngOnInit() {
    this.centroService.getCentros().map(x => x.json()).subscribe(
      x => this.dataSource = new MatTableDataSource<Element>(x)
    );
  }

}
