import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
import { UserService } from '../user.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {
  loginForm!: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router, private userService: UserService) { }
  userForm: any;
  invalidLogin: boolean = false;
  ngOnInit(): void {
  
    window.localStorage.removeItem('token');
    this.loginForm = this.formBuilder.group({
      username: ['', [Validators.required]],
      password: ['', [Validators.required]],
    });
  }
  loginsubmit()
  {
    if (this.loginForm.invalid) {
      return ;
    }
    const loginPayload = {
      username: this.loginForm.controls.username.value,
      password: this.loginForm.controls.password.value

    }
    this.userService.loginuser(loginPayload).subscribe(data => {
      //debugger;
      if (data.status === 200) {
        window.localStorage.setItem('token', data.result.token);
        window.localStorage.setItem('email', data.result.username);
        this.router.navigate(['homepage'])
      } 
      else{
        this.invalidLogin = true;
        alert(data.message);
      }
    });
  }
  

}
