
import { Injectable } from '@angular/core';
import { Router, RouterEvent, NavigationEnd } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class RouterExtService {

  private previousUrl: string = undefined;
  private currentUrl: string = undefined;

  constructor(private router: Router) {
    this.currentUrl = this.router.url;
    router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.previousUrl = this.currentUrl;
        this.currentUrl = event.url;
      };
    });
  }

  public getPreviousUrl(): string {
    //console.log(`previous: ${this.previousUrl} and current is: ${this.currentUrl}`)
    let prevUrl = window.location.pathname.split('/');
    let finalPrevUrl = prevUrl.slice(2, prevUrl.length).join('/')
  
    finalPrevUrl = finalPrevUrl === '' ? '/' : finalPrevUrl;
     console.log(finalPrevUrl)
    return finalPrevUrl;
  }


}
