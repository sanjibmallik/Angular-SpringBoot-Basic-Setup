import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private _fb: FormBuilder, private _loginService: LoginService) { }

  loginForm:FormGroup;

  ngOnInit(): void {
    this.loginForm =  this._fb.group({
      username:['user',[Validators.minLength(2)]],
      password: ['password',[Validators.minLength(2)]]
    })
  }

  onSubmitLogin(){
    console.log(this.loginForm.value)
    this._loginService.authenticateUser$(this.loginForm.value)
    .subscribe()

  }

}
