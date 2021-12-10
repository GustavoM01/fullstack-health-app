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

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http : HttpClient) { }

  getMeals() : Observable<Meal[]> {
    return this.http.get<Meal[]>(this.mealsUrl)
    .pipe(catchError(this.handleError<Meal[]>('getMeals', [])));
  }

  getMeal(id: number) : Observable<Meal> {
    return this.http.get<Meal>(`${this.mealsUrl}/${id}`)
    .pipe(catchError(this.handleError<Meal>('getMeal')));
  }

  saveMeal(meal : Meal) : Observable<Meal> {
    console.log(`Inside of mealService: ${meal.name}, ${meal.ingredients} and ${meal.date}`)
    return this.http.post<Meal>(this.mealsUrl, meal, this.httpOptions)
    .pipe(catchError(this.handleError<Meal>('saveMeal', meal)));
  }

  addIngredientToMeal(meal : Meal) : Observable<Meal> {
    return this.http.put<Meal>(this.mealsUrl, meal, this.httpOptions)
    .pipe(catchError(this.handleError<any>('addIngredientToMeal')));
  }

  handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }

}
