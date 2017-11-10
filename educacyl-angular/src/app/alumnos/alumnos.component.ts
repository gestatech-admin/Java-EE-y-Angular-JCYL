import {Component, OnInit} from '@angular/core';
import {AlumnosService} from './alumnos.service';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-alumnos',
  templateUrl: './alumnos.component.html',
  styleUrls: ['./alumnos.component.css']
})
export class AlumnosComponent implements OnInit {

  dataSource;
  displayedColumns = ['nombre'];

  constructor(private alumnosService: AlumnosService) {
  }

  ngOnInit() {
    this.alumnosService.getAlumnos().subscribe(
      (x: any) => this.dataSource = new MatTableDataSource<Element>(x)
    );
  }

}
