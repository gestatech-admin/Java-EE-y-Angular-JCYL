import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';

@Injectable()
export class CentroService {

  constructor(private http: HttpClient) {
  }

  getCentros() {
    return this.http.get('http://localhost:8080/educacyl-javaee/api/centros', {
      headers: new HttpHeaders({'Accept': 'application/json'}),
      withCredentials: true
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
