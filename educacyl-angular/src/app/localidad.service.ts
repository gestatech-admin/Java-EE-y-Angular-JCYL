import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable()
export class LocalidadService {

  constructor(private http: HttpClient) {
  }

  getLocalidadesConMunicipio(provinciaId: any, municipioId: any) {
    return this.http.get('http://localhost:8080/educacyl-javaee/api/localidades', {
      params: new HttpParams().set('provinciaId', provinciaId).set('municipioId', municipioId)
    });
  }
}
