import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Usermodel } from '../user';
import { UserService } from '../user.service';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  user:any ;
  tweet:any;



  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
    this.user = new FormGroup({
      'email': new FormControl('',),
      'tweetDesc': new FormControl('',),
      'firstName': new FormControl('',)
    })
    this.userService.getUserByEmailId(email).subscribe((response) => {
      this.user =response;
      console.log(response);
  })
  }

}
function email(email: any) {
  throw new Error('Function not implemented.');
}

