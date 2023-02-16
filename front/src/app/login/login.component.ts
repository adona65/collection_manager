import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { IUser } from '../models/user';
import { LoginService } from '../services/login.service';

/**
 * Component managing connection page.
 */
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  user: IUser = {username:'', password:''};

  constructor(private _loginSvc: LoginService, private router: Router) {}

  login() {
    this._loginSvc.logIn(this.user);

    this.router.navigateByUrl('user-main');
  }

}
