import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly userUrl = '/api/users/'

  constructor(private http : HttpClient) { }

  getUsers() {
    return this.http.get<User[]>(this.userUrl);
  }

  getUser(id: number) {
    return this.http.get<User>(this.userUrl + id);
  }

  addMealToUser(id : number) {
    return this.http.put<User>(this.userUrl + id, id);
  }
}
