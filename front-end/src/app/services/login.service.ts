import { UrlConstructService } from './url-construct.service';
import { AppToastrService } from './app-toastr.service';
import { Endpoints } from './../constants/endpoints.const';
import { RouterPath } from './../constants/router-path.const';
import { LoginUser } from './../models/userModels';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Router } from '@angular/router';
import { tap, map } from 'rxjs/operators';

const header = new HttpHeaders({
  'Content-type': 'application/x-www-form-urlencoded'
})


@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private _http: HttpClient,
    private _router: Router,
    private _toastr: AppToastrService,
    public _url: UrlConstructService) { }

  authenticateUser$(loginUser: LoginUser) {
    let url = this._url.mainUrl(Endpoints.LOGIN_AUTHENTICATE);
    console.log(url);
    let params = new HttpParams().set('username',loginUser.username).set('password',loginUser.password);
    return this._http.post(url, params, {
      headers: header,
      withCredentials: true
    })
      .pipe(
        map((data: any) => {
          let userDetails: LoginUser = data.loginDetails;
          if (loginUser.username === userDetails.username && loginUser.password === userDetails.password) {
            this._router.navigate([RouterPath.SLASH + RouterPath.DASHBOARD])
            this._toastr.success("Login successful");
            return true;
          }
          else {
            this._toastr.preventDuplicate();
            this._toastr.error("Error while login");
            return false;
          }
        })
      )

  }

}
