import { GlobalErrorHandlerService } from './error-handler/global-error-handler.service';
import { UrlConstructService } from './url-construct.service';
import { AppToastrService } from './app-toastr.service';
import { Endpoints } from './../constants/endpoints.const';
import { RouterPath } from './../constants/router-path.const';
import { LoginUser } from './../models/userModels';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpParams, HttpBackend, HttpErrorResponse } from '@angular/common/http';
import { Router } from '@angular/router';
import { tap, map, catchError } from 'rxjs/operators';

const header = new HttpHeaders({
	'Content-type': 'application/x-www-form-urlencoded'
})


@Injectable({
	providedIn: 'root'
})
export class LoginService {
	private loggedonUser: any = {};
	private httpClient: HttpClient;
	private authenticateStatus: boolean;

	constructor(private _http: HttpClient,
		private _router: Router,
		private _toastr: AppToastrService,
		public _url: UrlConstructService,
		handler: HttpBackend,
		private _errorHandler: GlobalErrorHandlerService) {
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
					this.storeSession(data);
					this._router.navigate([RouterPath.SLASH + RouterPath.DASHBOARD])
					this._toastr.success("Login successful");
				})
			)

	}

	validateSession() {
		this.isLoggedOn$()
			.subscribe(
				(data) => {
					//this.storeSession(data)
				},
				(err) => {
					this.sessionInvalidate();
				}
			)
	}

	storeSession(data) {
		if (data !== null && data.username != null) {
			this.loggedonUser.username = data.username;
			this.authenticateStatus = true;
			//console.log("Session Stored: ", this.authenticateStatus)	
		}
	}

	sessionInvalidate() {
		this.loggedonUser = {};
		this.authenticateStatus = false;
		this._router.navigate([RouterPath.SLASH + RouterPath.LOGIN])
	}

	isLoggedOn$() {
		let url = this._url.mainUrl(Endpoints.LOGGED_ON_USER);
		//console.log("called session check from app component")
		return this._http.get(url)
			.pipe(
				catchError((err: HttpErrorResponse) => this._errorHandler.errorHandler(err)),
				map((data) => {
					//console.log("calling store session")	
					this.storeSession(data)
				})
			)
	}

	isAuthenticated() {
		//console.log("returning auth: ", this.authenticateStatus)
		return this.authenticateStatus;
	}


}
