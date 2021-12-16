import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { IUser } from '../interfaces/user';
// import { User } from '../models/user.model'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private readonly userUrl = 'http://localhost:8100/input/user/'

  constructor(private http : HttpClient) { }

  getUsers() {
    return this.http.get<IUser[]>(this.userUrl);
  }

  getUser(id: number) : Observable<IUser> {
    return this.http.get<IUser>(`${this.userUrl}${id}`);
  }

  addMealToUser(id : number) {
    return this.http.put<IUser>(this.userUrl + id, id);
  }
}
