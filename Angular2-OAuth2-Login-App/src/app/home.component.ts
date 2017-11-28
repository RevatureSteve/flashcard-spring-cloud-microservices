import { Component,Input,OnInit } from '@angular/core';
import { User } from './user';
import { Headers, Http,RequestOptions } from '@angular/http';
import {Router, ActivatedRoute} from '@angular/router';
import {BackEndService} from './backend-service';


@Component({
  selector: 'home-app',
  template: `
  <div *ngIf="user">
    <h2>{{loggedInUser}}</h2>
    <div>
    <button (click)="logout()">Logout</button>
    <button (click)="getUpdatedUser()">Get Updated User</button>
    </div>
  </div>
  `
})

export class HomeComponent  {

  @Input('loggedInUser') loggedInUser: string
  constructor(
    private http: Http, 
    private router: Router,
    private backEndService :BackEndService) {}

  getUrl = "http://localhost:9090/getUpdatedUser";   
  logout(): void {
    localStorage.removeItem('currentUser');
    this.router.navigateByUrl('/login');
  }

  user = new User(
    JSON.parse( localStorage.getItem('currentUser')).userName,
      "");

  getUpdatedUser(): void{
    //added as it seems to throw an error on first request
    let user = new User(
      JSON.parse( localStorage.getItem('currentUser')).userName,
        "");
    this.backEndService.getUpdatedUser(user).subscribe(response => {
      this.loggedInUser = response.username;
    }, (error) => {
      console.log('error in', error);
    });
  }
}

