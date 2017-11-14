import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ListaCentrosService} from '../lista-centros.service';

@Component({
  selector: 'app-lista-centros',
  templateUrl: './lista-centros.component.html',
  styleUrls: ['./lista-centros.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ListaCentrosComponent implements OnInit {

  centros$;

  constructor(private listaCentrosService: ListaCentrosService) {
  }

  ngOnInit() {
    this.centros$ = this.listaCentrosService.getCentros(2);
  }

}
