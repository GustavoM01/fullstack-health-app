import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublicTopBarComponent } from './public-top-bar.component';

describe('PublicTopBarComponent', () => {
  let component: PublicTopBarComponent;
  let fixture: ComponentFixture<PublicTopBarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PublicTopBarComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PublicTopBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
