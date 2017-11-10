import {Component, OnInit, ViewChild} from '@angular/core';
import {AlumnosService} from './alumnos.service';
import {MatPaginator, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-alumnos',
  templateUrl: './alumnos.component.html',
  styleUrls: ['./alumnos.component.css']
})
export class AlumnosComponent implements OnInit {

  dataSource;
  displayedColumns = ['nombre'];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private alumnosService: AlumnosService) {

  }

  ngOnInit() {
    this.search(0);

    this.paginator.page.subscribe(x => {
      this.search(x.pageIndex);
    });
  }

  private search(page) {
    this.alumnosService.getAlumnos(page).subscribe(
      (x: any) => this.dataSource = new MatTableDataSource<Element>(x)
    );
  }
}
