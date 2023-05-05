import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { BehaviorSubject, catchError, of, tap } from 'rxjs';

import { IUser } from '../models/user';

/**
 * Service for managing all actions linked to user's log-in and log-out. 
 */
@Injectable({
  providedIn: 'root'
})
export class LoginService {

  // TODO : put those elsewhere (general service, configuration file...).
  backEndpoint = "http://localhost:8080";
  connectionService = "/user";

  private user = new BehaviorSubject<IUser>({username:'', password:''});
  private isLogged = new BehaviorSubject<boolean>(false);

  // Current user.
  observableUser$ = this.user.asObservable();
  // Flag telling if the user is currently authenticated.
  observableIsLogged$ = this.isLogged.asObservable();

  constructor(private http: HttpClient) {}

  /**
   * Log the user in.
   * 
   * @param user The user to log.
   * @param callback Optional argument that we can use to execute some code if the authentication is successful.
   */
  logIn(user: IUser, callback: any) {
    this.user.next(user);

    /**
     * Commentary keeped for tutorial purposes.
     * 
     * Mandatory headers for calling back-end services are added bu interceptor. But if we would like to add them manually
     * at the moment we call the service, we would do the following :
     * 
        // Headers for HTTP Basics auth (check if credentials is not null and not undefined).
        const headers = new HttpHeaders(credentials ? {
          // Encode credentials from String to Base64.
          authorization : 'Basic ' + Buffer.from(credentials.username + ':' + credentials.password).toString('base64')
        } : {});
        
        // Call the service with the headers.
        this.http.get('service_url', {headers: headers}).subscribe(.....);
     *
     */


    this.http.get(this.backEndpoint + this.connectionService)
              .pipe(
                // tap() is use to cause side effects when we got the response. The tap() call back doesn't 
                // access the values themselves.
                tap({
                  next: () => {
                    console.log("Successfully call /user service.")
                  },
                  error: (err) => {
                    console.log("Failed to call /user service. Http response : " + err.status)
                  }
                })
                // catchError() is used to handle error. Here we do nothing but returning empty value, and let subscribe() handle it.
                , catchError(err => {
                  return of([]);
                })
              )
              .subscribe(response => {
                if (response['name' as keyof typeof response]) {
                  this.isLogged.next(true);
                  // Save user for futur services call if connection successed.
                  this.user.next(user);
                } else {
                  this.isLogged.next(false);
                  // Reset user if connection failed.
                  this.user.next({username:'', password:''});
                }
                return callback && callback();
              });
  }

  /**
   * Log the user out.
   */
  logOut(): void {
    this.user.next({username:'', password:''});
    this.isLogged.next(false);
  }

  /**
   * @returns Base64 encoded values of user's credentials if credentials are set. Null otherwise.
   */
  getEncodedUser() {
    // TODO : replace deprecated btoa by Buffer.
    if(this.user.getValue().username && this.user.getValue().password) {
      return btoa(this.user.getValue().username + ':' + this.user.getValue().password);
    }
  
    return null;
  }

}