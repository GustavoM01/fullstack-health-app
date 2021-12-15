import { Component } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'trummy2';
  onUserProfile = false;
  userId? : number;

  constructor(private router : Router,
              private route : ActivatedRoute){}

  // Changes navbar if entering a user profile and pass userId to navbar component
  changeNavbar() {
    const url = this.router.url;
    if (url.includes('user/') || url.includes('symptom/')){
      this.onUserProfile = true;
      if (url.includes('/meal')) {
        this.userId = Number(url.slice(6, 7));
      } else {
        this.userId = Number(url.slice(url.length -1));
      }
    }
  }
}
