import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DwarfAddComponent } from './dwarf-add.component';

describe('DwarfAddComponent', () => {
  let component: DwarfAddComponent;
  let fixture: ComponentFixture<DwarfAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DwarfAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DwarfAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
