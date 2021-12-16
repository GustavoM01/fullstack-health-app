import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-user-navbar',
  templateUrl: './user-navbar.component.html',
  styleUrls: ['./user-navbar.component.css']
})
export class UserNavbarComponent implements OnInit {

  @Input() onUserProfile = false;
  @Input() userId? : number;
  
  constructor() { }

  ngOnInit(): void {
  }

}
