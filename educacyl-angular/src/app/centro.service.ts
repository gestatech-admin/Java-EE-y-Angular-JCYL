import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {HttpHeaders} from '@angular/common/http/src/headers';

@Injectable()
export class CentroService {

  constructor(private http: HttpClient) {
  }

  getCentros() {
    return this.http.get('http://localhost:8080/educacyl-javaee/api/centros', {
      headers: new HttpHeaders({'Accept': 'application/json'})
    });
  }

  cargarAlumnos(centroId) {
    return this.http.get('http://localhost:8080/educacyl-javaee/api/alumnos/centro/' + centroId, {
      headers: new HttpHeaders({'Accept': 'application/json'})
    });
  }

  filtrado(value) {

    const params = new HttpParams();
    params.set('filtro', JSON.stringify(value));

    // for (const key of Object.keys(value)) {
    //   params.append(key, value[key]);
    // }

    return this.http.get('http://localhost:8080/educacyl-javaee/api/centros/', {
      headers: new HttpHeaders({'Accept': 'application/json'}),
      params
    });
  }
}
