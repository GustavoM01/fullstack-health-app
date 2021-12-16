import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AboutComponent } from './components/about/about.component';
import { HomeComponent } from './components/home/home.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { UserMealDetailComponent } from './components/user-meal-detail/user-meal-detail.component';

const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'users', component: UserListComponent},
  {path: 'about', component: AboutComponent},
  {path: 'user/:id', component: UserDashboardComponent},
  {path: 'user/:id/meal', component: UserMealDetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
