import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ClientComponent } from './client/client.component';
import { HotelComponent } from './hotel/hotel.component';
import { ResaComponent } from './resa/resa.component';
import {AuthentificationGuard} from "./authentification.guard";

const routes: Routes = [
 {path: 'login', component: LoginComponent},
  {path: 'client',component: ClientComponent, canActivate: [AuthentificationGuard]},
  {path: 'resa',component: ResaComponent, canActivate: [AuthentificationGuard]},
  {path: 'hotel',component: HotelComponent, canActivate: [AuthentificationGuard]},
  {path: '', redirectTo: '/login', pathMatch: 'full'} 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
