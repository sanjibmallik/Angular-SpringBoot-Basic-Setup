import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpEvent, HttpRequest, HttpHandler, HttpXsrfTokenExtractor, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class HttpInterceptorService implements HttpInterceptor {
  authReq: any;

  constructor(private _tokenExtractor: HttpXsrfTokenExtractor) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    if (this._tokenExtractor.getToken()) {

      this.authReq = req.clone({
        headers: new HttpHeaders(
          {
            'Content-Type': 'application/json',
            'X-XSRF-TOKEN': this._tokenExtractor.getToken()
          }
        ),
        withCredentials: true
      });
    } else {
      this.authReq = req.clone({
        headers: new HttpHeaders({
          'Content-Type': 'application/json'

        }
        ),
        withCredentials: true

      });
    }

    return next.handle(this.authReq).pipe(

    )
  }
}
