import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Usermodel } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-resetpassword',
  templateUrl: './resetpassword.component.html',
  styleUrls: ['./resetpassword.component.css']
})
export class ResetpasswordComponent implements OnInit {
  user: Usermodel = new Usermodel();
  resetpasswordform:any;
  errorMessage:any;
  isNew!: boolean;
  successMessage:any;
  email = this.actRoute.snapshot.params.email;
  
 // email!: String;
  constructor(private userService:UserService,private router:Router, private actRoute:ActivatedRoute,) { }

  ngOnInit()
  {
    this.resetpasswordform = new FormGroup({
      'password': new FormControl('', [Validators.required]),
      'confirmPassword': new FormControl('', [Validators.required]),
      'email': new FormControl(localStorage.getItem('email'),)
      
      })
    this.email=window.localStorage.getItem('email');

    if(this.email){
      this.isNew = false;
     // this.userService.getUserByEmailId().subscribe(
     // (data: Usermodel)=>{
     // this.user=data;
     // }
     // );
      }else{
      this.isNew = true;
     this.user = {
        
      "email": this.user.email,
      "firstName": this.user.firstName,
      "lastName": this.user.lastName,
      "password": " ",
      "confirmPassword": " ",
      "username": this.user.username,
      "tweet": this.user.tweet

     }

  }

   
  }

  resetpassword(resetpasswordform : any)
   {

    let ob: Observable<Usermodel>;
    let email = window.localStorage.getItem('email');
    ob = this.userService.resetpass( resetpasswordform.value);
    ob.subscribe((response:any) =>{ 
      console.log(response);
      alert('Password reset successfully');
      this.router.navigate(["/homepage"]);
    },
    (errResponse)=>{
      this.errorMessage = errResponse.error;
    } );


  }

}
