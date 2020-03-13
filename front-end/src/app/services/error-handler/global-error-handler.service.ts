import { RouterPath } from './../../constants/router-path.const';
import { Router } from '@angular/router';

import { Injectable } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class GlobalErrorHandlerService {

  constructor(private _router: Router) { }

  errorHandler(error: HttpErrorResponse) {
    if (error.status === 403) {
      this._router.navigate([RouterPath.SLASH + RouterPath.LOGIN])
      return throwError(error)
    } else {
      return throwError(error)
    }
  }
}
