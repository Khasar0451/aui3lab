import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WeaponEditComponent } from './weapon-edit.component';

describe('WeaponEditComponent', () => {
  let component: WeaponEditComponent;
  let fixture: ComponentFixture<WeaponEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [WeaponEditComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(WeaponEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
