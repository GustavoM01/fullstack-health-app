import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  
  username: string = '';
  password: string = '';
  newUser: User = new User(this.username, this.password);

  constructor(private userService : UserService) { }

  ngOnInit(): void {
  }

  register() {

    this.newUser.setUsername(this.username);
    this.newUser.setPassword(this.password);
    console.log(this.newUser);
    this.userService.saveNewUser(this.newUser).subscribe();
  }

}
