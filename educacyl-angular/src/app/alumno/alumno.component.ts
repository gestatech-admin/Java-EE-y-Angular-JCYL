import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-alumno',
  templateUrl: './alumno.component.html',
  styleUrls: ['./alumno.component.css']
})
export class AlumnoComponent {

  @Input()
  alumnoInput;

  @Output()
  editandoAlumno = new EventEmitter();

  enviar() {
    console.log('hijo', this.alumnoInput);

    this.editandoAlumno.emit({valor: 'prueba'});
  }

}









