import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError } from 'rxjs/operators';

import { Symptom } from '../interfaces/symptom';

@Injectable({
  providedIn: 'root'
})
export class SymptomService {

  private readonly symptomUrl = 'http://localhost:8100/input/symptom/';

  constructor(private http : HttpClient) { }

  getSymptoms() : Observable<Symptom[]> {
    return this.http.get<Symptom[]>(this.symptomUrl)
    .pipe(catchError(this.handleError<Symptom[]>('getSymptoms', [])));
  }

  getSymptomsByUser(userId : number) : Observable<Symptom[]> {
    return this.http.get<Symptom[]>(this.symptomUrl + userId)
    .pipe(catchError(this.handleError<Symptom[]>('getSymptomsByUser', [])));
  }

  updateSymptom(symptom : Symptom) : Observable<Symptom> {
    return this.http.put<Symptom>(this.symptomUrl + '/update/' + symptom.id, symptom);
  }

  saveSymptom(symptom : Symptom) : Observable<Symptom> {
    return this.http.post<Symptom>(this.symptomUrl, symptom);
  }

  deleteSymptom(symptomId : number) : Observable<Symptom> {
    return this.http.delete<Symptom>(this.symptomUrl + symptomId);
  }

  handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
