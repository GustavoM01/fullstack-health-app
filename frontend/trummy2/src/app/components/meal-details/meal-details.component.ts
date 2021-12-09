import { Component, OnInit, Input, SimpleChanges, OnChanges } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { MealService } from 'src/app/services/meal.service';
import { Ingredient } from 'src/app/interfaces/ingredient';
import { Meal } from '../../interfaces/meal';
import { IngredientService } from 'src/app/services/ingredient.service';



@Component({
  selector: 'app-meal-details',
  templateUrl: './meal-details.component.html',
  styleUrls: ['./meal-details.component.css']
})
export class MealDetailsComponent implements OnInit {

  @Input()  meal?: Meal;
  @Input() addIngredient? : Ingredient;
  ingredients : Ingredient[] = []; 


  constructor(private route : ActivatedRoute,
              private mealService : MealService,
              private ingredientService : IngredientService,
              private location : Location) { }

  ngOnInit(): void {
    this.getMeal();
  }

  async getMeal(): Promise<void> {
    const routeParams = this.route.snapshot.paramMap
    const idFromRoute = Number(routeParams.get('id'));

    const mealPromise = await this.mealService.getMeal(idFromRoute).toPromise();
    this.meal = mealPromise;

    const ingredientsPromise = await this.ingredientService.getAllIngredients().toPromise();
    this.ingredients = ingredientsPromise.filter(ingredient => this.meal!.ingredients.includes(ingredient.id));
  
  }

  onAddIngredient(ingredient: Ingredient): void {
    if(this.meal) {
      this.meal.ingredients.push(ingredient.id);
      this.mealService.addIngredientToMeal(this.meal).subscribe();
      console.log(`Meal ingredients: ${this.meal.ingredients}`);
      this.getMeal();
    }
  }

  // save(): void {
  //   if (this.meal) {
  //     this.meal.ingredients.push()
  //     this.mealService.addIngredient(this.meal)
  //     .subscribe(() => this.goBack());
  //   }
  // }

  goBack(): void {
    this.location.back();
  }

}
