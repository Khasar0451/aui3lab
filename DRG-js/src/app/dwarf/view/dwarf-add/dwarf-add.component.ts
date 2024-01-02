import { Component } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";
import {DwarfService} from "../../service/dwarf.service";
import {ActivatedRoute, Router} from "@angular/router";
import {v4 as uuidv4} from "uuid"
@Component({
  selector: 'app-dwarf-add',
  standalone: true,
    imports: [
        FormsModule,
        NgIf,
        ReactiveFormsModule
    ],
  templateUrl: './dwarf-add.component.html',
  styleUrl: './dwarf-add.component.css'
})
export class DwarfAddComponent {
  constructor(
    private dwarfService: DwarfService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }
  onSubmit(): void {
    this.dwarfService.putDwarf(uuidv4() ,this.dwarf!)
      .subscribe(() => this.router.navigate(['/dwarves']));
  }
}
