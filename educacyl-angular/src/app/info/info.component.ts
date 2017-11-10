import {Component, OnInit} from '@angular/core';
import {UsuarioService} from '../usuario/usuario.service';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
  selector: 'app-info',
  templateUrl: './info.component.html',
  styleUrls: ['./info.component.css']
})
export class InfoComponent implements OnInit {

  constructor(private usuarioService: UsuarioService) {
  }

  ngOnInit() {
  }


  loguear(login, password) {
    this.usuarioService.login(login, password);
  }

}
