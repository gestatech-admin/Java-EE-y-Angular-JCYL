import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable()
export class MunicipioService {

  constructor(private http: HttpClient) {
  }

  getMunicipiosConProvincia(provinciaId: any) {
    return this.http.get('http://localhost:8080/educacyl-javaee/api/municipios', {
      params: new HttpParams().set('provinciaId', provinciaId)
    });
  }
}
