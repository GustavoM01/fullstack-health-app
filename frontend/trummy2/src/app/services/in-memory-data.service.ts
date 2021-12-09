import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Ingredient } from '../interfaces/ingredient';
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

    const ingredients: Ingredient[] = [
      { id: 1, name: 'Tomato' },
      { id: 2, name: 'Cheese' },
      { id: 3, name: 'Bread' },
      { id: 4, name: 'Beef' },
      { id: 5, name: 'Chicken' },
      { id: 6, name: 'Lettuce' },
      { id: 7, name: 'Onion' },
      { id: 8, name: 'Walnut' },
      { id: 9, name: 'Oatmeal' }
    ]
    return { meals, ingredients};
  }

  genId<T extends Meal | Ingredient>(myTable : T[]): number {
    return myTable.length > 0 ? Math.max(...myTable.map(item => item.id)) + 1 : 1;
  }
}
