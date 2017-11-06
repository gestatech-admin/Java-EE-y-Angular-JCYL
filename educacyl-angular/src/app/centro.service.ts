import {Injectable} from '@angular/core';
import {Headers, Http} from '@angular/http';
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

}
