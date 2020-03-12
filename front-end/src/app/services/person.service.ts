import { UrlConstructService } from './url-construct.service';
import { Person } from './../models/userModels';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Endpoints } from '../constants/endpoints.const';

@Injectable({
  providedIn: 'root'
})
export class PersonService {

  constructor(private _http: HttpClient,
    private _url: UrlConstructService) { }

  createPerson$(person: Person) {
    let url = this._url.mainUrl(Endpoints.CREATE_PERSON);
    return this._http.post(url, person)
      .pipe(
        
      )

  }




}
