import { Injectable, NgModule } from '@angular/core';
import { HTTP_INTERCEPTORS, HttpClientModule, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './login/login.component';
import { UserMainComponent } from './user-main/user-main.component';
import { HeaderComponent } from './header/header.component';
import { LoginService } from './services/login.service';
import { IUser } from './models/user';

/**
 * The following injectable class intercept all HttpRequest send by Angular before they reach their destination. This allow us to perform some required actions on
 * requests like adding useful headers.
 * 
 * For example credentials in "Basic authorization" for being allowed to call services from Spring boot back end part and got
 * a proper response instead of a HTTP 401. So we don't have to add them each time we call a service. This interceptor do it conveniently for us.
 * 
 * This injectable need to be declared in the providers of this module in order to work.
 */
@Injectable()
export class XhrInterceptor implements HttpInterceptor {

  constructor(private _loginSvc: LoginService) {}

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const xhr = req.clone(this._loginSvc.getEncodedUser() ? {
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
      .set("Access-Control-Allow-Origin", "*")
      .set('authorization', 'Basic ' + this._loginSvc.getEncodedUser())
      .set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, authorization")
    } : {
      headers: req.headers.set('X-Requested-With', 'XMLHttpRequest')
      .set("Access-Control-Allow-Origin", "*")
      .set("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, authorization")
    });

    return next.handle(xhr);
  }
}

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    UserMainComponent,
    HeaderComponent
  ],
  imports: [
    BrowserModule
    , AppRoutingModule
    , FormsModule
    , HttpClientModule
  ],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: XhrInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
