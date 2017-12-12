import {BrowserModule} from '@angular/platform-browser';
import {ErrorHandler, NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {CentrosComponent} from './centros/centros.component';
import {CentroComponent} from './centro/centro.component';
import {CentroService} from './centros/centro.service';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MAT_PLACEHOLDER_GLOBAL_OPTIONS, MatCardModule, MatIconModule, MatInputModule, MatListModule, MatMenuModule,
  MatTableModule
} from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {ProvinciaComponent} from './provincia/provincia.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {FlexLayoutModule} from '@angular/flex-layout';
import {ProvinciaService} from './provincia/provincia.service';
import {RouterModule} from '@angular/router';
import {InfoComponent} from './info/info.component';
import {DatosComponent} from './datos/datos.component';
import {UsuarioService} from './usuario/usuario.service';
import {TokenInterceptor} from './usuario/token.interceptor';
import {AuthGuard} from './usuario/auth.guard';
import {AuthService} from './usuario/auth.service';
import {AuthErrorHandler} from './usuario/errorhandler';
import {LocalidadComponent} from './localidad/localidad.component';
import {SelectorLocalidadComponent} from './selector-localidad/selector-localidad.component';
import {SelectorProvinciaComponent} from './selector-provincia/selector-provincia.component';
import {SelectorMunicipioComponent} from './selector-municipio/selector-municipio.component';
import {MunicipioService} from './municipio/municipio.service';
import {LocalidadService} from './localidad.service';

const routes = [
  {path: '', component: InfoComponent},
  {path: 'alumno', loadChildren: 'app/alumnos/alumnos.module#AlumnosModule'},
  {path: 'listado-centros', component: CentrosComponent, canActivate: [AuthGuard]},
  {path: 'centro', component: CentroComponent},
  {path: 'datos', component: DatosComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    CentrosComponent,
    CentroComponent,
    ProvinciaComponent,
    InfoComponent,
    DatosComponent,
    LocalidadComponent,
    SelectorLocalidadComponent,
    SelectorProvinciaComponent,
    SelectorMunicipioComponent,
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
    RouterModule.forRoot(routes)
  ],
  providers: [CentroService, ProvinciaService, UsuarioService, AuthGuard, AuthService, MunicipioService, LocalidadService,
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
