import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { IUser } from 'src/app/interfaces/user';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  userList : IUser[] = [];

  constructor(private userService : UserService) { }

  ngOnInit(): void {
    this.userService.getUsers().subscribe(users => this.userList = users);
  }

}
