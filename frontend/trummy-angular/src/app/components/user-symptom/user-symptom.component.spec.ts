import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserSymptomComponent } from './user-symptom.component';

describe('UserSymptomComponent', () => {
  let component: UserSymptomComponent;
  let fixture: ComponentFixture<UserSymptomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserSymptomComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserSymptomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
