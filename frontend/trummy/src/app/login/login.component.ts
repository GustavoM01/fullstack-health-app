import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';
  password: string = '';
  userLogin: User = new User(this.username, this.password);

  foundUser! : User;

  success: boolean = false;


  constructor(private userService : UserService) { }

  ngOnInit(): void {
  }

  login() {
    this.userService.login(this.userLogin).subscribe(x => this.foundUser = x);
  }

}
