import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-provincia',
  templateUrl: './provincia.component.html',
  styleUrls: ['./provincia.component.css']
})
export class ProvinciaComponent implements OnInit {

  name;

  constructor() {
    setInterval(() => {
      this.name = Math.random();
    }, 1000);
  }

  ngOnInit() {
  }

}
