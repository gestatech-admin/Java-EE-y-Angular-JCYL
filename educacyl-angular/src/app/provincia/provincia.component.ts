import {Component, OnInit} from '@angular/core';
import {ProvinciaService} from './provincia.service';

@Component({
  selector: 'app-provincia',
  template:
      `
    <p *ngFor="let provincia of provincias">
      {{provincia.nombre}}
    </p>
  `,
  styleUrls: ['./provincia.component.css']
})
export class ProvinciaComponent implements OnInit {

  provincias;

  ngOnInit(): void {
    var obs = this.provinciaService
      .getDiezProvincias()
      .toPromise();

    obs.then(datos => {
      this.provincias = datos;
      console.log('dentro', this.provincias);
    }).catch(err => console.log(err));

    // obs.subscribe(datos => {
    //   this.provincias = datos;
    //   console.log('dentro', this.provincias);
    // }, err => console.log(err));
  }

  alumnos: Array<any> = [
    {nombre: 'Jorge', esPrimaria: false},
    {nombre: 'Juan', esPrimaria: true},
    {nombre: 'Jose', esPrimaria: false}
  ];

  constructor(private provinciaService: ProvinciaService) {
  }

  escuchar($event) {
    console.log('Padre', $event);
  }

}
