import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {CentrosComponent} from './centros/centros.component';
import {CentroComponent} from './centro/centro.component';
import {CentroService} from './centro.service';
import {HttpModule} from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    CentrosComponent,
    CentroComponent
  ],
  imports: [
    BrowserModule,
    HttpModule
  ],
  providers: [CentroService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
