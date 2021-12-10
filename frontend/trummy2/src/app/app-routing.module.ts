import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MealDetailsComponent } from './components/meal-details/meal-details.component';
import { MealListComponent } from './components/meal-list/meal-list.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { UserMealDetailComponent } from './components/user-meal-detail/user-meal-detail.component';

const routes: Routes = [
  {path: '', component: MealListComponent},
  {path: 'meal/:id', component: MealDetailsComponent},
  {path: 'users', component: UserListComponent},
  {path: 'user/:id', component: UserMealDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
