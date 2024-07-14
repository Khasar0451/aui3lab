import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DwarfEditComponent } from './dwarf-edit.component';

describe('DwarfEditComponent', () => {
  let component: DwarfEditComponent;
  let fixture: ComponentFixture<DwarfEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DwarfEditComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DwarfEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
