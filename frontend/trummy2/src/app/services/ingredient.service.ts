import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import { Ingredient } from '../interfaces/ingredient';

@Injectable({
  providedIn: 'root'
})
export class IngredientService {

  private ingredientsUrl = 'api/ingredients'; // URL to web api

  httpOptions = {
    headers: new HttpHeaders({'Content-Type': 'application/json'})
  };

  constructor(private http : HttpClient) { }

  searchIngredients(term : string) : Observable<Ingredient[]> {
    if (!term.trim()) {
      return of([]);
    }
    return this.http.get<Ingredient[]>(`${this.ingredientsUrl}?name=${term}`)
    .pipe(catchError(this.handleError<Ingredient[]>('searchIngredients', []))); 
  }

  private handleError<T>(operation = 'operation', result?:T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
