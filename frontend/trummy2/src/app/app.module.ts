import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MealListComponent } from './components/meal-list/meal-list.component';
import { MealDetailsComponent } from './components/meal-details/meal-details.component';
import { InMemoryDataService } from './services/in-memory-data.service';
import { IngredientSearchComponent } from './components/ingredient-search/ingredient-search.component';
import { UserListComponent } from './components/user-list/user-list.component';
import { UserMealDetailComponent } from './components/user-meal-detail/user-meal-detail.component';
import { MealFormComponent } from './components/meal-form/meal-form.component';

@NgModule({
  declarations: [
    AppComponent,
    MealListComponent,
    MealDetailsComponent,
    IngredientSearchComponent,
    UserListComponent,
    UserMealDetailComponent,
    MealFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    HttpClientInMemoryWebApiModule.forRoot(InMemoryDataService, {dataEncapsulation: false})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
