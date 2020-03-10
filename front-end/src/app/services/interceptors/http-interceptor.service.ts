import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpEvent, HttpRequest, HttpHandler, HttpXsrfTokenExtractor } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class HttpInterceptorService implements HttpInterceptor {

  constructor(private _tokenExtractor: HttpXsrfTokenExtractor) { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const authReq = req.clone({

    });
    return next.handle(authReq).pipe(
    
    )
  }
}
