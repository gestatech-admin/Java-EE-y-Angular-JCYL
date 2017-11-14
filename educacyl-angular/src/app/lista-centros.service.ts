import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';

@Injectable()
export class ListaCentrosService {

  constructor(private httpClient: HttpClient) {
  }

  getCentros(page) {

    let params = new HttpParams();
    params = params.set('page', page);
    return this.httpClient.get('http://localhost:8080/educacyl-javaee/api/centros', {params: params});
  }
}
