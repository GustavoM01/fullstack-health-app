import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Meal } from '../interfaces/meal';


@Injectable({
  providedIn: 'root'
})
export class MealService {

  private mealsUrl = 'api/meals';

  constructor(private http : HttpClient) { }

  getMeals() : Observable<Meal[]> {
    return this.http.get<Meal[]>(this.mealsUrl)
    .pipe(catchError(this.handleError<Meal[]>('getMeals', [])));
  }

  getMeal(id: number) : Observable<Meal> {
    return this.http.get<Meal>(`${this.mealsUrl}/${id}`)
    .pipe(catchError(this.handleError<Meal>('getMeal')));
  }

  handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

}
