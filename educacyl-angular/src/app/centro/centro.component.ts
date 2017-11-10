import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-centro',
  templateUrl: './centro.component.html',
  styleUrls: ['./centro.component.css']
})
export class CentroComponent implements OnInit {

  form;

  constructor(private formBuilder: FormBuilder) {
  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      name: new FormControl('a', Validators.required),
      date: 'b', date1: 'b', date2: 'b', date3: 'b', date4: 'b', date5: 'b',
      date6: 'b', date7: 'b', date8: 'b', date9: 'b', date10: 'b', date11: 'b',
      date12: 'b', date13: 'b', date14: 'b', date15: 'b', date16: 'b', date17: 'b',
      date18: 'b', date19: 'b', date20: 'b'
    });
  }

}
