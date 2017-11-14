import {Component} from '@angular/core';
import {FormBuilder, FormControl} from '@angular/forms';

@Component({
  selector: 'app-alumno',
  templateUrl: './alumno.component.html',
  styleUrls: ['./alumno.component.css']
})
export class AlumnoComponent {

  form;
  apellido2;
  alumno = {nombreAlumno: 's'};

  constructor(private fb: FormBuilder) {
    this.apellido2 = new FormControl('asd', this.miValidacion);
    this.apellido2.valueChanges.subscribe(x => console.log(x));
    this.form = this.fb.group({
      nombre: 'javier',
      apellido1: '',
      apellido2: this.apellido2
    });
  }

  miValidacion(value) {
    console.log(value);
    if (value === 'javier') {
      return {valor: true};
    }
    return null;
  }

  enviar() {
    console.log(this.form);
  }

}









