import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { UserService } from 'src/app/services/user.service';
import { MealService } from 'src/app/services/meal.service';
import { User } from '../../interfaces/user';
import { Meal } from '../../interfaces/meal';
import { Ingredient } from 'src/app/interfaces/ingredient';
import { IngredientService } from 'src/app/services/ingredient.service';

@Component({
  selector: 'app-user-meal-detail',
  templateUrl: './user-meal-detail.component.html',
  styleUrls: ['./user-meal-detail.component.css']
})
export class UserMealDetailComponent implements OnInit {

  user! : User;
  meals : Meal[] = [];

  // For adding new meal
  addMealDisplayForm : boolean = false;
  newMeal? : Meal;


  constructor(private route : ActivatedRoute,
              private userService : UserService,
              private mealService : MealService) { }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const idFromRoute = Number(routeParams.get('id'));

    this.getUser(idFromRoute);
  }

  async getUser(id: number): Promise<void> {
    const userPromise = await this.userService.getUser(id).toPromise();
    this.user = userPromise;

    const mealsPromise = await this.mealService.getMeals().toPromise();
    this.meals = mealsPromise.filter(meal => this.user.mealList.includes(meal.id)); 
  }

  async addMeal(meal : Meal): Promise<void> {
    console.log(`The meal to add is: ${meal.name} with ${meal.ingredients}`);
    this.newMeal = await this.mealService.saveMeal(meal).toPromise();
    this.userService.addMealToUser(this.newMeal.id);
    this.meals.push(this.newMeal);
  }

  onAddIngredient(ingredient : Ingredient): void {
    if(this.newMeal) {
      this.newMeal.ingredients.push(ingredient.id);
      console.log(ingredient);
    }
  }

  displayForm(): void {
    this.addMealDisplayForm = !this.addMealDisplayForm;
  }

}
