import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Observable } from 'rxjs';

import { IngredientService } from 'src/app/services/ingredient.service';
import { Meal } from 'src/app/models/meal.model';
import { Ingredient } from 'src/app/interfaces/ingredient';

@Component({
  selector: 'app-meal-form',
  templateUrl: './meal-form.component.html',
  styleUrls: ['./meal-form.component.css']
})
export class MealFormComponent implements OnInit {

  @Output() newMeal = new EventEmitter<Meal>();

  model = new Meal (0, '', [], new Date());

  submitted = false;

  ingredients$! : Observable<Ingredient[]>;

  constructor(private ingredientService : IngredientService) { }

  ngOnInit(): void {
    this.getIngredients();
  }

  onSubmit() {
    console.log(this.model);
    this.newMeal.emit(this.model);
  }

  getIngredients() {
    this.ingredients$ = this.ingredientService.getAllIngredients();
  }

}
