import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {CentrosComponent} from './centros/centros.component';
import {CentroComponent} from './centro/centro.component';
import {CentroService} from './centro.service';
import {HttpModule} from '@angular/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatIconModule, MatListModule, MatTableModule} from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { ProvinciaComponent } from './provincia/provincia.component';

@NgModule({
  declarations: [
    AppComponent,
    CentrosComponent,
    CentroComponent,
    ProvinciaComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    BrowserAnimationsModule,
    MatListModule, MatIconModule, MatTableModule, FormsModule, ReactiveFormsModule
  ],
  providers: [CentroService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
