import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {AlumnoComponent} from '../alumno/alumno.component';
import {AlumnosComponent} from './alumnos.component';
import {AlumnosService} from './alumnos.service';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatPaginatorModule, MatTableModule} from '@angular/material';
import {RouterModule} from '@angular/router';

const routes = [
  {path: '', component: AlumnoComponent},
  {path: 'alumnos', component: AlumnosComponent},
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatPaginatorModule,
    MatTableModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    AlumnoComponent,
    AlumnosComponent,
  ],
  exports: [AlumnoComponent],
  providers: [AlumnosService]
})
export class AlumnosModule {
}
