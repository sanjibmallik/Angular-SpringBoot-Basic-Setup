import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class AppToastrService {

  constructor(private _toastr: ToastrService) { }

  success(message) {
    this._toastr.success(message);
  }

  error(message) {
    this._toastr.error(message)
  }

  preventDuplicate(){
    this._toastr.toastrConfig.preventDuplicates = true;
  }
}
