import { Injectable } from '@angular/core';

import { BehaviorSubject } from 'rxjs';

import { IUser } from '../models/user';

/**
 * Service for managing all actions linked to user's log-in and log-out. 
 */
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  private user = new BehaviorSubject<IUser>({username:'', password:''});
  private isLogged = new BehaviorSubject<boolean>(false);

  observableUser$ = this.user.asObservable();
  observableIsLogged$ = this.isLogged.asObservable();

  constructor() {}

  /**
   * Log the user in.
   * 
   * @param user The user to log.
   */
  logIn(user: IUser): void {
    this.user.next(user);
    this.isLogged.next(true);
  }

  /**
   * Log the user out.
   */
  logOut(): void {
    this.user.next({username:'', password:''});
    this.isLogged.next(false);
  }

}