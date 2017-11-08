import {Injectable} from '@angular/core';
import {Headers, Http, URLSearchParams} from '@angular/http';
import {RequestOptionsArgs} from '@angular/http/src/interfaces';

@Injectable()
export class CentroService {

  constructor(private http: Http) {
  }

  getCentros() {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    const requestOptionsArgs: RequestOptionsArgs = {headers};
    return this.http.get('http://localhost:8080/educacyl-javaee/api/centros', requestOptionsArgs);
  }

  cargarAlumnos(centroId) {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    const requestOptionsArgs: RequestOptionsArgs = {headers};
    return this.http.get('http://localhost:8080/educacyl-javaee/api/alumnos/centro/' + centroId, requestOptionsArgs);
  }

  filtrado(value) {
    const headers: Headers = new Headers();
    headers.append('Accept', 'application/json');
    const params = new URLSearchParams();

    for (const key of Object.keys(value)) {
      params.append(key, value[key]);
    }

    const requestOptionsArgs: RequestOptionsArgs = {headers, params};

    return this.http.get('http://localhost:8080/educacyl-javaee/api/centros/filtrado/', requestOptionsArgs);
  }
}
