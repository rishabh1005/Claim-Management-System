import { Component, OnInit } from '@angular/core';

import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../registration.service';
import { User } from '../user';

@Component({
  selector: 'app-login-module',
  templateUrl: './login-module.component.html',
  styleUrls: ['./login-module.component.css']
})
export class LoginModuleComponent implements OnInit {
  user = new User();
  errormsg = '';

  constructor(private _service: RegistrationService, private _route: Router) { }

  ngOnInit(): void {

  }
  /**
  * This function will get the data from backend
  * and after successfull validation it will provide the data otherwise error
  */
  loginUser() {
    this._service.loginUserFormRemote(this.user).subscribe(
      data => {
        console.log("response received");
        console.log(data);
        this._route.navigate(['/memberModule'], {
          skipLocationChange: true,
          queryParams: {
            data: JSON.stringify(data)
          }

        });
        localStorage.setItem("jwtToken", data.jwtToken)
      },
      error => {
        //this._route.navigate(['/error'])
        console.log(error);
        this.errormsg = "Please Enter Correct Username or Password";
      }
    )
  }

}
