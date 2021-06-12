import { LoginComponent } from './login/login.component';

export class Usermodel {
    email!: string;
    firstName!: string;
    lastName!: string;
    username!: string;
    password!: string;
    confirmPassword!: string;
    tweet!: Tweet[];
}

export class Tweet {
    tweetDesc!: string;
    tweetTag!: string;
    tweetId!: any;
    date!: any;
    email!: string;
    recordActive!: string;
}