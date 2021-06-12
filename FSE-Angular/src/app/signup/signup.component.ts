import { Component, OnInit, ɵConsole } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../user.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  
  signupForm:any;
  errorMessage:any;
  confirmPassword:any;
  emailPattern!: any;
  
 
  constructor(private userService:UserService,private router:Router) { 
    
  }

  ngOnInit()
  { 
    this.emailPattern = "^[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[a-z]{2,3}$"
    this.confirmPassword='';
    this.signupForm = new FormGroup({
      'email': new FormControl('', [Validators.required ,Validators.pattern('[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[a-z]{2,3}$')]),
      'firstName': new FormControl('', [Validators.required]),
      'lastName': new FormControl(''),
      'password': new FormControl('', [Validators.required , Validators.maxLength(4), Validators.minLength(4)]),
      'gender': new FormControl('male', [Validators.required]),
      })
  }

  signupsubmit(signupForm:any)
  {
    console.log(signupForm);
    this.errorMessage=null;
  
    this.userService.addUser(signupForm.value).subscribe((response:any) =>{
      if(response.errorMessage!==null)
      {
        this.errorMessage=response.errorMessage;
      }

      
      console.log(response)
    },(error) => {
      console.log(error);
       })
       alert('Successfully register!!');
       this.router.navigate(['/login'])
      }

      
      get passwordCheck() {​​​​​​​
     return !(this.signupForm.get('password').value === this.confirmPassword);
  ​
      }​
  
  
}
