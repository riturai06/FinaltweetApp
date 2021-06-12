import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSliderModule } from '@angular/material/slider';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { TwitterComponent } from './twitter/twitter.component';
import { ResetpasswordComponent } from './resetpassword/resetpassword.component';
import { HeaderComponent } from './header/header.component';
import { AllUsersComponent } from './all-users/all-users.component';
import { MyTweetsComponent } from './my-tweets/my-tweets.component';
import { TokenInterceptor } from './Interceptor';
import { APP_BASE_HREF } from '@angular/common';
import {MatIconModule} from '@angular/material/icon';
import { LogoutComponent } from './logout/logout.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { TwitterrComponent } from './twitterr/twitterr.component';


@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    TwitterComponent,
    ResetpasswordComponent,
    HeaderComponent,
    AllUsersComponent,
    MyTweetsComponent,
    LogoutComponent,
    UserDetailsComponent,
    TwitterrComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatSliderModule,
    MatIconModule
   
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptor,
    multi:true
  }, HttpClientModule,  {
    provide: APP_BASE_HREF, 
    useValue : '/' }],
  bootstrap: [AppComponent]
})

export class AppModule { }
