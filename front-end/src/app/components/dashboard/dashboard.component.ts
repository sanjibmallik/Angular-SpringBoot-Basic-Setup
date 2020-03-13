import { RouterPath } from './../../constants/router-path.const';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private _router: Router) { }

  ngOnInit(): void {
    //console.log('here')
  }

  goToPersonView() {
    this._router.navigate([RouterPath.SLASH + RouterPath.PERSON])
  }



}
