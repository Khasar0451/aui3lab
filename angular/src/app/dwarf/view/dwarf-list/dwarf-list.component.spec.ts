import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DwarfListComponent } from './dwarf-list.component';

describe('DwarfListComponent', () => {
  let component: DwarfListComponent;
  let fixture: ComponentFixture<DwarfListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DwarfListComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DwarfListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
