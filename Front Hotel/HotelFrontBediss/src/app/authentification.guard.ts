import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationGuard implements CanActivate {


  constructor(private router: Router) {
  }

  canActivate(

    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

   if (sessionStorage.getItem("connectedUser")) {
      return true;
    }

    else {
      this.router.navigate(['login']);
      return false;
    } 

    
  }

  isConnected(): boolean
  {
    if (sessionStorage.getItem("connectedUser"))
      return true;
    else
      return false;
  }


  

}
