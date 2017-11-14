import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';

import {AuthService} from './auth.service';

// declare var jwt_decode: any;

@Injectable()
export class UsuarioService {

  constructor(private http: HttpClient, private authService: AuthService) {
  }

  login(login: any, password: any) {

    const body = new URLSearchParams();
    body.set('login', login);
    body.set('password', password);

    this.http.post('http://localhost:8080/educacyl-javaee/api/usuarios/login', body.toString(), {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded'),
      responseType: 'text',
      observe: 'response',
    }).subscribe(resp => {

      let header = resp.headers.get('Authorization');
      header = header.replace('Bearer ', '');
      console.log(header);
      this.authService.setToken(header);

    }, (error: HttpErrorResponse) => {
      console.error(error);
    });
  }

}
