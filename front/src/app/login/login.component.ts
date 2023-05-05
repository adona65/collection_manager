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

  // TODO : properly manage error messages for whole application, as we manage header in dedicated component.
  errorMessage:string = "";
  displayError:boolean = false;

  observableUser$:IUser  = {username:'', password:''};
  observableIsLogged$:boolean = false;

  constructor(private _loginSvc: LoginService, private router: Router) {}

  ngOnInit() {
    this._loginSvc.observableUser$.subscribe(user => this.observableUser$ = user);
    this._loginSvc.observableIsLogged$.subscribe(isLogged => this.observableIsLogged$ = isLogged);
  }

  // Todo : Manage logg-in process with a method taking route as parameter directly inside _loginSvc
  login() {
    this._loginSvc.logIn(this.observableUser$, () => {
      if(this.observableIsLogged$) {
        console.log("Successfully logged in.");

        this.displayError = false;
        this.errorMessage = "";

        this.router.navigateByUrl('user-main');
      } else {
        console.log("Failed to log in.");

        this.displayError = true;
        this.errorMessage = "An error happened during connection. Please try again.";
      }
    });
  }

}
