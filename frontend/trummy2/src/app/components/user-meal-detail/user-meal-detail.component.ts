import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { UserService } from 'src/app/services/user.service';
import { MealService } from 'src/app/services/meal.service';
import { IUser } from '../../interfaces/user';
import { Meal } from '../../interfaces/meal';
import { Ingredient } from 'src/app/interfaces/ingredient';
import { IngredientService } from 'src/app/services/ingredient.service';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-user-meal-detail',
  templateUrl: './user-meal-detail.component.html',
  styleUrls: ['./user-meal-detail.component.css']
})
export class UserMealDetailComponent implements OnInit {

  user! : IUser;
  meals! : Meal[];

  // For adding new meal
  addMealDisplayForm : boolean = false;
  newMeal! : Meal;


  constructor(private route : ActivatedRoute,
              private userService : UserService,
              private mealService : MealService) { }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const idFromRoute = Number(routeParams.get('id'));
    this.getUser(idFromRoute);
  }

  async getUser(id: number) : Promise<void> {
    const userPromise = await this.userService.getUser(id).toPromise();
    this.user = userPromise;
    const mealPromise = await this.mealService.getMeals().toPromise();
    this.meals = mealPromise.filter(meal => this.user.mealList.includes(meal.mealId));
      
  }

  async addMeal(meal : Meal): Promise<void> {
    this.newMeal = await this.mealService.saveMeal(meal).toPromise();
    this.userService.addMealToUser(this.newMeal.mealId);
    this.meals.push(this.newMeal);
  }

  onAddIngredient(ingredient : Ingredient): void {
    if(this.newMeal) {
      this.newMeal.ingredients.push(ingredient.id);
    }
  }

  displayForm(): void {
    this.addMealDisplayForm = !this.addMealDisplayForm;
  }

}
