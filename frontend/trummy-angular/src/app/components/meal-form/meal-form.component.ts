import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

import { IngredientService } from 'src/app/services/ingredient.service';
import { Meal } from 'src/app/interfaces/meal';
import { Ingredient } from 'src/app/interfaces/ingredient';

@Component({
  selector: 'app-meal-form',
  templateUrl: './meal-form.component.html',
  styleUrls: ['./meal-form.component.css']
})
export class MealFormComponent implements OnInit {

  @Input() isEdit = false;
  @Output() newMeal = new EventEmitter<Meal>();

  model : Meal = {} as Meal;
  @Input() editModel? : Meal;

  submitted = false;

  ingredientList : Ingredient[] = [];

  constructor(private ingredientService : IngredientService) { }

  ngOnInit(): void {
    this.getIngredients();
    if (this.editModel) {
      this.model = this.editModel;
    }
      
  }

  onSubmit() {
    if(!this.model.dateConsumed){
        this.model.dateConsumed = new Date();
    }
    this.newMeal.emit(this.model);
  }

  async getIngredients() : Promise<void> {
    const ingredientsPromise = await this.ingredientService.getAllIngredients().toPromise();
    this.ingredientList = ingredientsPromise;
    
  }
}
