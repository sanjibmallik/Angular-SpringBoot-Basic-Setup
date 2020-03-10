import { DEV_PORT } from './../constants/endpoints.const';
import { Injectable } from '@angular/core';

// @ts-ignore
import * as baseUrl from './../../baseurl/base.json';

@Injectable({
  providedIn: 'root'
})
export class UrlConstructService {
  private url: string;
  private isOn4200: boolean;
  constructor() {
    this.isOn4200 = (window.location.port == DEV_PORT)
    this.url = baseUrl['base'];
  }

  getIsOn4200(): boolean {
    return this.isOn4200;
  }


  mainUrl(path: string) {
    let use = (this.getIsOn4200() === true) ? this.url + '/' + path : '/' + path;
    return use;
  }


}
