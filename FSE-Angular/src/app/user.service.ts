import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { BehaviorSubject, Observable, Subject } from 'rxjs';
import { ApiResponse } from './api.response';
import { Usermodel } from './user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  user: Usermodel[] = [];
  public flag = new Subject<any>();
  // email: string= window.localStorage.getItem('email');
  // username:string = window.localStorage.getItem('username');
  public setFlag(message: any) {
  this.flag.next(message);
  }  
   public getFlag(): Observable<any> {
  return this.flag.asObservable();
  }
 
  constructor(private httpClient: HttpClient) {
   
  }

  email = window.localStorage.getItem('email');

  addUser(user:Object):Observable<Object> {
    console.log(JSON.stringify(user));
    return this.httpClient.post(`http://15.207.100.52:8094/api/v1.0/tweets/register`, user);
  }

  loginuser(loginPayload: {
      username: any; 
      password: any;
    }) : Observable<ApiResponse> {
    return this.httpClient.post<ApiResponse>(`http://15.207.100.52:8094/api/v1.0/tweets/login`, loginPayload);
  }


  gettweets(){
    
    return this.httpClient.get("http://15.207.100.52:8094/api/v1.0/tweets/gettweets/{email}");
  }

  addtweet(user:any){
    return this.httpClient.post("http://15.207.100.52:8094/api/v1.0/tweets/posttweet",user);
    
    
  }

  getUserByEmailId(email: any){
    return this.httpClient.get(`http://15.207.100.52:8094/api/v1.0/tweets/search/`+this.email);
  }

  resetpass(user: any)
  {
    this.email = window.localStorage.getItem('email');
    return this.httpClient.patch<any>(`http://15.207.100.52:8094/api/v1.0/tweets/reset/` +this.email ,user);
  }

  postcomments(user:any)
  {
    return this.httpClient.post("http://15.207.100.52:8094/api/v1.0/tweets/replyTweet",user);
  }

  getAllUsers():Observable<Object>
  {
    return this.httpClient.get("http://15.207.100.52:8094/api/v1.0/tweets/getAllUser");
  }

  getAllTweets()
  {
    return this.httpClient.get("http://15.207.100.52:8094/api/v1.0/tweets/UsersTweet/?email="+localStorage.getItem('email'));
  }

  deleteTweet(index:any)
  {
    return this.httpClient.delete(`http://15.207.100.52:8094/api/v1.0/tweets/deleteTweet/`+index);
  }

}
