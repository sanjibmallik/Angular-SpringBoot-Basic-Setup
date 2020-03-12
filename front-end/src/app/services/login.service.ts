import { UrlConstructService } from './url-construct.service';
import { AppToastrService } from './app-toastr.service';
import { Endpoints } from './../constants/endpoints.const';
import { RouterPath } from './../constants/router-path.const';
import { LoginUser } from './../models/userModels';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpBackend } from '@angular/common/http';
import { Router } from '@angular/router';
import { tap, map } from 'rxjs/operators';

const header = new HttpHeaders({
	'Content-type': 'application/x-www-form-urlencoded'
})


@Injectable({
	providedIn: 'root'
})
export class LoginService {
	
	private httpClient:HttpClient;
	private authenticateStatus: boolean = false;

	constructor(private _http: HttpClient,
		private _router: Router,
		private _toastr: AppToastrService,
		public _url: UrlConstructService,
		handler: HttpBackend) {
		this.httpClient = new HttpClient(handler);
	}

	authenticateUser$(loginUser: LoginUser) {
		let url = this._url.mainUrl(Endpoints.LOGIN_AUTHENTICATE);
		console.log(url);
		let params = new HttpParams().set('username', loginUser.username).set('password', loginUser.password);
		return this.httpClient.post(url, params, {
			headers: header
		})
			.pipe(
				map((data: any) => {
					this.authenticateStatus = true;
					this._router.navigate([RouterPath.SLASH + RouterPath.DASHBOARD])
					this._toastr.success("Login successful");
				})
			)

	}

	isAuthenticated(){
		return this.authenticateStatus;
	}

}
