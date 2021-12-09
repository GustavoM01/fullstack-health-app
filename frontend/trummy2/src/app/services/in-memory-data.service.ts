import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Meal } from '../interfaces/meal';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {

  createDb() {
    const meals: Meal[] = [
      {
        id: 1,
        name: 'Pizza',
        ingredients: [1, 2, 3]
      },
      {
        id: 2,
        name: 'Hamburger',
        ingredients: [4, 5, 6]
      },
      {
        id: 3,
        name: 'Salad',
        ingredients: [7, 8, 9]
      }
    ];
    return { meals };
  }

  genId(meals: Meal[]): number {
    return meals.length > 0 ? Math.max(...meals.map(meal => meal.id)) + 1 : 1;
  }
}
