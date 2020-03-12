import { PersonService } from './../../services/person.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { AppToastrService } from 'src/app/services/app-toastr.service';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  personForm: FormGroup

  constructor(private _fb: FormBuilder,
    private _personService: PersonService,
    private _toastr: AppToastrService) { }

  ngOnInit(): void {
    this.personForm = this._fb.group({
      firstName: ['', [Validators.minLength(2)]],
      lastName: ['', [Validators.minLength(2)]],
      cardNumber: ['', [Validators.minLength(12)]],
      emailOne: ['', [Validators.minLength(2), Validators.email]],
      emailTwo: ['', [Validators.minLength(2), Validators.email]],
      age: ['', [Validators.minLength(2)]]
    })
  }


  submitPersonForm() {
    console.log(this.personForm.value);
    this._personService.createPerson$(this.personForm.value)
      .subscribe(
        (data) => {
          this._toastr.success(`Successfully Created ${this.personForm.controls.firstName.value} !!!`)
          console.log(data);
        },
        (error: any) => {

          if (error.status == 400) {
            this._toastr.error(`Error Happed while Creating ${this.personForm.controls.firstName.value} !!!
            ${error.error.errors.toString()}`)
          } else if (error.status == 500) {
            this._toastr.error(`Error Happed while Creating ${this.personForm.controls.firstName.value} !!!
            ${error.error.message}`)
          }

        })

  }

}
