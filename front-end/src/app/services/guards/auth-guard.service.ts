import { RouterPath } from './../../constants/router-path.const';
import { LoginService } from './../login.service';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private _loginService: LoginService, private _router: Router) { }
  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (this._loginService.isAuthenticated() === true) {
      return true
    } else {
      this._router.navigate([RouterPath.SLASH+ RouterPath.LOGIN])
      return false;
    }


  }
}
