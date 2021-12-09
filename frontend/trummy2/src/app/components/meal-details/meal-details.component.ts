import { Component, OnInit, Input, SimpleChanges, OnChanges } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { MealService } from 'src/app/services/meal.service';
import { Ingredient } from 'src/app/interfaces/ingredient';
import { Meal } from '../../interfaces/meal';



@Component({
  selector: 'app-meal-details',
  templateUrl: './meal-details.component.html',
  styleUrls: ['./meal-details.component.css']
})
export class MealDetailsComponent implements OnInit, OnChanges {

  @Input()  meal?: Meal;
  @Input() addIngredient? : Ingredient;


  constructor(private route : ActivatedRoute,
              private mealService : MealService,
              private location : Location) { }

  ngOnInit(): void {
    this.getMeal();
  }

  ngOnChanges(changes : SimpleChanges): void {
    this.getMeal();
  }

  getMeal(): void {
    const routeParams = this.route.snapshot.paramMap
    const idFromRoute = Number(routeParams.get('id'));

    this.mealService.getMeal(idFromRoute).subscribe(meal => this.meal = meal);
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
