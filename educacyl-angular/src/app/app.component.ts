import {Component} from '@angular/core';
import {AuthService} from './usuario/auth.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  template: `

    <div style="height:100px; background-color:#684480"></div>

    <div id="menu">
      <button mat-button [matMenuTriggerFor]="centros">Centros</button>
      <button mat-button [matMenuTriggerFor]="alumnos">Alumnos</button>
      <button mat-button [routerLink]="['/datos']">Datos</button>
      <button mat-button (click)="logout()">Logout</button>
      <mat-menu #centros="matMenu">
        <button mat-menu-item [routerLink]="['/centros']">Listado</button>
        <button mat-menu-item [routerLink]="['/centro']">Alta</button>
      </mat-menu>
      <mat-menu #alumnos="matMenu">
        <button mat-menu-item [routerLink]="['/alumnos']">Listado</button>
        <button mat-menu-item>Alta</button>
      </mat-menu>
    </div>

    <router-outlet style="min-height: 400px"></router-outlet>

    <div style="height:50px; background-color:#684480"></div>
  `,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'app';

  constructor(private authService: AuthService, private router: Router) {

  }

  logout() {
    this.authService.logout();
    this.router.navigate(['']);
  }
}
