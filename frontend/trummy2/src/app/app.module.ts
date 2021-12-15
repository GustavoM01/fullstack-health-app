import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { FormsModule } from '@angular/forms';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MealListComponent } from './components/meal-list/meal-list.component';
import { MealDetailsComponent } from './components/meal-details/meal-details.component';
// import { InMemoryDataService } from './services/in-memory-data.service';
import { IngredientSearchComponent } from './components/ingredient-search/ingredient-search.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { UserMealDetailComponent } from './components/user-meal-detail/user-meal-detail.component';
import { MealFormComponent } from './components/meal-form/meal-form.component';
import { UserNavbarComponent } from './components/user-navbar/user-navbar.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { UserDashboardComponent } from './components/user-dashboard/user-dashboard.component';
import { UserSymptomComponent } from './components/user-symptom/user-symptom.component';



@NgModule({
  declarations: [
    AppComponent,
    MealListComponent,
    MealDetailsComponent,
    IngredientSearchComponent,
    UserListComponent,
    UserMealDetailComponent,
    MealFormComponent,
    UserNavbarComponent,
    HomeComponent,
    AboutComponent,
    UserDashboardComponent,
    UserSymptomComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    MatCheckboxModule,
    BrowserAnimationsModule,
    // HttpClientInMemoryWebApiModule.forRoot(InMemoryDataService, {dataEncapsulation: false})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
