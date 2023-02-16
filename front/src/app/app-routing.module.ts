import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { UserMainComponent } from './user-main/user-main.component';

/**
 * Module for managing Routes inside application.
 */
const appRoutes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: 'home'}
  , { path: 'home', component: HomeComponent}
  , { path: 'user-main', component: UserMainComponent}
];

@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
