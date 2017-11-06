import {Component, OnInit} from '@angular/core';
import {CentroService} from '../centro.service';
import 'rxjs/add/operator/map';

@Component({
  selector: 'app-centros',
  template: `
    <div *ngFor="let centro of (centros$ | async)">
      <a href="">{{centro.nombre}}</a>
    </div>
  `,
  styleUrls: ['./centros.component.css']
})
export class CentrosComponent implements OnInit {

  centros$;

  constructor(private centroService: CentroService) {
  }

  ngOnInit() {
    this.centros$ = this.centroService.getCentros().map(x => x.json());
  }

}
