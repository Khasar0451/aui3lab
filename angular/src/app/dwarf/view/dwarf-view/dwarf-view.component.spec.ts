import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DwarfViewComponent } from './dwarf-view.component';

describe('DwarfViewComponent', () => {
  let component: DwarfViewComponent;
  let fixture: ComponentFixture<DwarfViewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DwarfViewComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DwarfViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
