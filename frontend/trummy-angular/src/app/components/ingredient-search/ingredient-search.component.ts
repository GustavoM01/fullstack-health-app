import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';
import { Location } from '@angular/common';

import { IngredientService } from 'src/app/services/ingredient.service';
import { Ingredient } from '../../interfaces/ingredient';

@Component({
  selector: 'app-ingredient-search',
  templateUrl: './ingredient-search.component.html',
  styleUrls: ['./ingredient-search.component.css']
})
export class IngredientSearchComponent implements OnInit {

  ingredients$! : Observable<Ingredient[]>;
  private searchTerms = new Subject<string>();

  @Output() newIngredientEvent = new EventEmitter<Ingredient>();

  constructor(private ingredientService : IngredientService,
              private location : Location) { }

  ngOnInit(): void {
    this.ingredients$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((term: string) => this.ingredientService.searchIngredients(term)));
  }

  search(term: string): void {
    this.searchTerms.next(term);
  }

  addIngredientToMeal(ingredient: Ingredient): void {
    console.log(ingredient);
    this.newIngredientEvent.emit(ingredient);

  }

}
