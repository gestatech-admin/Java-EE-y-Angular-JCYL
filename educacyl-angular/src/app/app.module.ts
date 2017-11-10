import {BrowserModule} from '@angular/platform-browser';
import {ErrorHandler, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {CentrosComponent} from './centros/centros.component';
import {CentroComponent} from './centro/centro.component';
import {CentroService} from './centros/centro.service';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MAT_PLACEHOLDER_GLOBAL_OPTIONS,
  MatCardModule,
  MatIconModule,
  MatInputModule,
  MatListModule,
  MatMenuModule,
  MatPaginatorModule,
  MatTableModule
} from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ProvinciaComponent} from './provincia/provincia.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FlexLayoutModule} from '@angular/flex-layout';
import {AlumnoComponent} from './alumno/alumno.component';
import {ProvinciaService} from './provincia/provincia.service';
import {RouterModule} from '@angular/router';
import {AlumnosComponent} from './alumnos/alumnos.component';
import {InfoComponent} from './info/info.component';
import {DatosComponent} from './datos/datos.component';
import {UsuarioService} from './usuario/usuario.service';
import {TokenInterceptor} from './usuario/token.interceptor';
import {AuthGuard} from './usuario/auth.guard';
import {AuthService} from './usuario/auth.service';
import {AuthErrorHandler} from './usuario/errorhandler';
import {AlumnosService} from './alumnos/alumnos.service';

const routes = [
  {path: '', component: InfoComponent},
  {path: 'alumno', component: AlumnoComponent},
  {path: 'centros', component: CentrosComponent, canActivate: [AuthGuard]},
  {path: 'centro', component: CentroComponent},
  {path: 'alumnos', component: AlumnosComponent},
  {path: 'datos', component: DatosComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    CentrosComponent,
    CentroComponent,
    ProvinciaComponent,
    AlumnoComponent,
    AlumnosComponent,
    InfoComponent,
    DatosComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    FlexLayoutModule,
    MatCardModule,
    MatInputModule,
    MatMenuModule,
    MatListModule,
    MatIconModule,
    MatTableModule,
    MatPaginatorModule,
    RouterModule.forRoot(routes)
  ],
  providers: [CentroService, ProvinciaService, UsuarioService, AuthGuard, AuthService, AlumnosService,
    {provide: MAT_PLACEHOLDER_GLOBAL_OPTIONS, useValue: {float: 'always'}},
    {
      provide: HTTP_INTERCEPTORS,
      useClass: TokenInterceptor,
      multi: true
    }, {
      provide: ErrorHandler,
      useClass: AuthErrorHandler
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
