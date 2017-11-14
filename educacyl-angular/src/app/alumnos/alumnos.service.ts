import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';

@Injectable()
export class AlumnosService {

  constructor(private http: HttpClient) {
  }

  getAlumnos(page) {
    return this.http.get('http://localhost:8080/educacyl-javaee/api/alumnos', {
      headers: new HttpHeaders({'Accept': 'application/json'}),
      params: new HttpParams().set('page', page)
    });
  }

}
