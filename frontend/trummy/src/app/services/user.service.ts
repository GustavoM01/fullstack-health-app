import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8100/input/user';

  constructor(private http: HttpClient) { }

  saveNewUser(user: User): Observable<User> {
    return this.http.post<User>(this.baseUrl, user);
  }
}
