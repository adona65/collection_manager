import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { IUser } from '../models/user';
import { LoginService } from '../services/login.service';

/**
* Module for managing navigation menu displayed atop the application
*/
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {

  observableUser$: IUser  = {username:'', password:''};
  observableIsLogged$: boolean = false;


  constructor(private _loginSvc: LoginService, private router: Router) {}

  ngOnInit() {
    this._loginSvc.observableUser$.subscribe(user => this.observableUser$ = user);
    this._loginSvc.observableIsLogged$.subscribe(isLogged => this.observableIsLogged$ = isLogged);
  }

  /**
   * Log-out the user then redirect to home page.
   */
  logout() {
    this._loginSvc.logOut();

    this.router.navigateByUrl('home');
  }
}
