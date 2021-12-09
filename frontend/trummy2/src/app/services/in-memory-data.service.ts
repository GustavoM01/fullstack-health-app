import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Ingredient } from '../interfaces/ingredient';
import { Meal } from '../interfaces/meal';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {

  createDb() {
    const meals: Meal[] = [
      {
        id: 1,
        name: 'Pizza',
        ingredients: [1, 2, 3],
        date: new Date('December 1, 2021 15:24:00')
      },
      {
        id: 2,
        name: 'Hamburger',
        ingredients: [4, 5, 6],
        date: new Date('December 1, 2021 21:24:00')
      },
      {
        id: 3,
        name: 'Salad',
        ingredients: [7, 8, 9],
        date: new Date('December 2, 2021 9:24:00')
      },
      {
        id: 4,
        name: 'Pizza',
        ingredients: [1, 2, 3],
        date: new Date('December 2, 2021 15:24:00')
      },
      {
        id: 5,
        name: 'Pasta',
        ingredients: [4, 5, 6],
        date: new Date('December 2, 2021 21:24:00')
      },
      {
        id: 6,
        name: 'Soup',
        ingredients: [7, 8, 9],
        date: new Date('December 3, 2021 9:24:00')
      },
      {
        id: 7,
        name: 'Thai noodles',
        ingredients: [1, 2, 3],
        date: new Date('December 3, 2021 15:24:00')
      },
      {
        id: 8,
        name: 'Rice',
        ingredients: [4, 5, 6],
        date: new Date('December 3, 2021 21:24:00')
      },
      {
        id: 9,
        name: 'Hot dog',
        ingredients: [7, 8, 9],
        date: new Date('December 4, 2021 9:24:00')
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

    const users: User[] = [
      {id: 1, username: 'jhon', password: '123', mealList: [1, 2, 3]},
      {id: 2, username: 'jane', password: '123', mealList: [4, 5, 6]},
      {id: 3, username: 'joe', password: '123', mealList: [7, 8, 9]}

    ]

    return { meals, ingredients, users};
  }

  genId<T extends Meal | Ingredient | User>(myTable : T[]): number {
    return myTable.length > 0 ? Math.max(...myTable.map(item => item.id)) + 1 : 1;
  }
}
