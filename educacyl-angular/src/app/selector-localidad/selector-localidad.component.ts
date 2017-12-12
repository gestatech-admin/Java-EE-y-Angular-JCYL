import {Component, EventEmitter, Input, OnInit, Output, ViewEncapsulation} from '@angular/core';
import {LocalidadService} from '../localidad.service';

@Component({
  selector: 'app-selector-localidad',
  template: `
    <label for="localidad">Localidad:</label>
    <select id="localidad" (change)="seleccionada($event.target.value)">
      <option></option>
      <option *ngFor="let localidad of localidades$ | async"
              name="localidad" [value]="localidad.localidadId">
        {{localidad.descripcion}}
      </option>
    </select>
  `,
  encapsulation: ViewEncapsulation.None
})
export class SelectorLocalidadComponent implements OnInit {

  localidades$: any;

  private _provinciaId;
  private _municipioId;

  constructor(private localidadService: LocalidadService) {
  }

  ngOnInit() {
  }

  @Input() set provinciaId(provinciaId) {
    this._provinciaId = provinciaId;
    this.buscarLocalidades();
  }

  @Input() set municipioId(municipioId) {
    this._municipioId = municipioId;
    this.buscarLocalidades();
  }

  @Output()
  private localidadSeleccionada: EventEmitter<any> = new EventEmitter();

  private buscarLocalidades() {
    if (this._provinciaId && this._municipioId) {
      this.localidades$ = this.localidadService.getLocalidadesConMunicipio(this._provinciaId, this._municipioId);
    }
  }

  seleccionada(localidadId) {
    this.localidadSeleccionada.emit({
      provinciaId: this._provinciaId,
      municipioId: this._municipioId,
      localidadId
    });
  }

}
