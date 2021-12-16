import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserMealDetailComponent } from './user-meal-detail.component';

describe('UserDetailComponent', () => {
  let component: UserMealDetailComponent;
  let fixture: ComponentFixture<UserMealDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserMealDetailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserMealDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
