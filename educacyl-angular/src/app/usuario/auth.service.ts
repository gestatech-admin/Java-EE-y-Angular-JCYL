import {Injectable} from '@angular/core';
import * as jwt_decode from 'jwt-decode';

@Injectable()
export class AuthService {

  constructor() {
  }

  getToken(): string {
    return localStorage.getItem('token');
  }

  setToken(token: string): void {
    if (!token) {
      localStorage.removeItem('token');
    } else {
      localStorage.setItem('token', token);
    }
  }

  private getTokenExpirationDate(token: string): Date {
    const decoded = jwt_decode(token);
    console.log(decoded);

    if (decoded.exp === undefined) return null;

    const date = new Date(0);
    date.setUTCSeconds(decoded.exp);
    return date;
  }

  isTokenExpired(): boolean {

    let token = this.getToken();
    if (!token) return true;

    const date = this.getTokenExpirationDate(token);
    if (date === undefined) return false;
    // return !(date.valueOf() > new Date().valueOf());
    return false;
  }

  logout() {
    this.setToken(null);
  }
}
