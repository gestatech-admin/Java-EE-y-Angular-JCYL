import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class ProvinciaService {

  constructor(private http: HttpClient) {
  }

  getProvincias() {
    return this.http.get('http://localhost:8080/educacyl-javaee/api/provincias');
  }

  getDiezProvincias() {
    return this.getProvincias()
      .map((x: any) => x.slice(0, 10));
  }

}
