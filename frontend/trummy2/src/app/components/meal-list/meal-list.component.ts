import { Component, OnInit } from '@angular/core';

import { MealService } from 'src/app/services/meal.service';
import { Meal } from '../../interfaces/meal';

@Component({
  selector: 'app-meal-list',
  templateUrl: './meal-list.component.html',
  styleUrls: ['./meal-list.component.css']
})
export class MealListComponent implements OnInit {

  meals : Meal[] = [];

  constructor(private mealService : MealService) { }

  ngOnInit(): void {
    this.getMeals();
    console.log(this.meals);
  }

  getMeals() {
    this.mealService.getMeals().subscribe(
      (meals) => {
        this.meals = meals;
      });
  }

}
