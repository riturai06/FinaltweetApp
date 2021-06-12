import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllUsersComponent } from './all-users/all-users.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { MyTweetsComponent } from './my-tweets/my-tweets.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { SignupComponent } from './signup/signup.component';
import { TwitterComponent } from './twitter/twitter.component';
import { TwitterrComponent } from './twitterr/twitterr.component';
import { UserDetailsComponent } from './user-details/user-details.component';

const routes: Routes = [{path:"signup",component:SignupComponent},
  {path:"login",component:LoginComponent},{path:"homepage",component:TwitterComponent},{path:"",component:TwitterrComponent},{path:"reset",component:ResetpasswordComponent},{path:"userdetails",component:UserDetailsComponent},{path:"allUsers",component:AllUsersComponent},{path:"myTweet",component:MyTweetsComponent},{path:"header",component:ResetpasswordComponent}, {path:"logout",component:LogoutComponent}];



@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
