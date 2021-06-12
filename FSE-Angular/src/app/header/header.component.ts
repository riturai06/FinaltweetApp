import { Component, OnInit, OnDestroy } from '@angular/core';
import { from, interval, Subscription } from 'rxjs';
import { trigger, state,style, animate,transition} from '@angular/animations';
import { UserService } from '../user.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Usermodel } from '../user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  animations: [
    
  ]
})
export class HeaderComponent implements OnInit, OnDestroy {
  title = 'Twitter';
  searchtweetsform: any;

    constructor(private userService:UserService) {

   }

  notifications = 0;
  showSpinner = false;
  email!: any;
  token!: any;
  username!:any;
  isLoggedIn: boolean = false;
  user : Usermodel= new Usermodel;

  ngOnInit(): void {
    this.username = window.localStorage.getItem('username');
    this.token = window.localStorage.getItem('token');
    this.email= window.localStorage.getItem('email');
    if (this.token != null && this.token.length > 10) {
      this.isLoggedIn = true;
    }


    this.searchtweetsform = new FormGroup({
      'email': new FormControl(localStorage.getItem('email'),)
    })

  }
  updateStats() {
    throw new Error('Method not implemented.');
  }


  loaddata() {
    this.showSpinner = true;
    setTimeout(() => {
      this.showSpinner = false;
    }, 10000);
  }

  searchByEmail(email: Usermodel){
 
    this.userService.getAllTweets().subscribe(response =>{
      
      console.log(response);
    },(error)=>{
      this.ngOnInit();
    }
      );
  }
  ngOnDestroy() {
    //this.mediaSub.unsubscribe();
  }
}



