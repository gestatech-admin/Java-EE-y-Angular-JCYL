import {Component, OnInit} from '@angular/core';
import {CentroService} from '../centro.service';
import 'rxjs/add/operator/map';
import {MatTableDataSource} from '@angular/material';
import {FormBuilder, FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-centros',
  template: `

    <div class="container">
      <div fxLayout="row"
           fxLayout.xs="column"
           fxLayout.sm="column"
           fxFlex class="contentResp">
        <div class="blocks" fxFlex> ...  </div>
        <div class="blocks" fxFlex> ...  </div>
      </div>
    </div>

    <div class="container">
      <div class="row">
        <div class="col-12 col-md-8">.col-12 .col-md-8</div>
        <div class="col-6 col-md-4">.col-6 .col-md-4</div>
      </div>

      <div class="row">
        <div class="col-6 col-md-4">.col-6 .col-md-4</div>
        <div class="col-6 col-md-4">.col-6 .col-md-4</div>
        <div class="col-6 col-md-4">.col-6 .col-md-4</div>
      </div>

      <div class="row">
        <div class="col-6">.col-6</div>
        <div class="col-6">.col-6</div>
      </div>

      <div class="row">
        <div class="col-md-4">.col-md-4</div>
        <div class="col-md-4 offset-md-4">.col-md-4 .offset-md-4</div>
      </div>
    </div>

    <form>

      <input [formGroup]="form" [formControl]="form.controls['name']">

      <input [formGroup]="form" [formControl]="form.controls['date']">
      <input [formGroup]="form" [formControl]="form.controls['date1']">
      <input [formGroup]="form" [formControl]="form.controls['date2']">
      <input [formGroup]="form" [formControl]="form.controls['date3']">
      <input [formGroup]="form" [formControl]="form.controls['date4']">
      <input [formGroup]="form" [formControl]="form.controls['date5']">
      <input [formGroup]="form" [formControl]="form.controls['date6']">
      <input [formGroup]="form" [formControl]="form.controls['date7']">
      <input [formGroup]="form" [formControl]="form.controls['date8']">
      <input [formGroup]="form" [formControl]="form.controls['date9']">
      <input [formGroup]="form" [formControl]="form.controls['date10']">
      <input [formGroup]="form" [formControl]="form.controls['date11']">
      <input [formGroup]="form" [formControl]="form.controls['date12']">
      <input [formGroup]="form" [formControl]="form.controls['date13']">
      <input [formGroup]="form" [formControl]="form.controls['date14']">
      <input [formGroup]="form" [formControl]="form.controls['date15']">
      <input [formGroup]="form" [formControl]="form.controls['date16']">
      <input [formGroup]="form" [formControl]="form.controls['date17']">
      <input [formGroup]="form" [formControl]="form.controls['date18']">
      <input [formGroup]="form" [formControl]="form.controls['date19']">
      <input [formGroup]="form" [formControl]="form.controls['date20']">

      <button (click)="enviar()">Enviar</button>

    </form>

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

  form;

  displayedColumns = ['centroId', 'nombre', 'cursoId'];

  constructor(private centroService: CentroService, private formBuilder: FormBuilder) {
    this.form = this.formBuilder.group({
      name: new FormControl('a', Validators.required),
      date: 'b', date1: 'b', date2: 'b', date3: 'b', date4: 'b', date5: 'b',
      date6: 'b', date7: 'b', date8: 'b', date9: 'b', date10: 'b', date11: 'b',
      date12: 'b', date13: 'b', date14: 'b', date15: 'b', date16: 'b', date17: 'b',
      date18: 'b', date19: 'b', date20: 'b'
    });
  }

  cargarCentro(row) {
    this.alumnos$ = this.centroService.cargarAlumnos(row.centroId);
  }

  enviar() {
    console.log(this.form.value);
    this.centroService.filtrado(this.form.value).subscribe(
      x => console.log(x)
    );
  }

  ngOnInit() {
    this.centroService.getCentros().subscribe(
      (x: any) => this.dataSource = new MatTableDataSource<Element>(x)
    );
  }

}
