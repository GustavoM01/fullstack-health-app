import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { MealService } from 'src/app/services/meal.service';
import { Meal } from '../../interfaces/meal';



@Component({
  selector: 'app-meal-details',
  templateUrl: './meal-details.component.html',
  styleUrls: ['./meal-details.component.css']
})
export class MealDetailsComponent implements OnInit {

  @Input() meal?: Meal;


  constructor(private route : ActivatedRoute,
              private mealService : MealService) { }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap
    const idFromRoute = Number(routeParams.get('id'));

    this.mealService.getMeal(idFromRoute).subscribe(meal => this.meal = meal);
  }

}
