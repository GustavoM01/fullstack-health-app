import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { UserService } from 'src/app/services/user.service';
import { MealService } from 'src/app/services/meal.service';
import { User } from '../../interfaces/user';
import { Meal } from '../../interfaces/meal';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  user! : User;
  meals : Meal[] = [];


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

}
