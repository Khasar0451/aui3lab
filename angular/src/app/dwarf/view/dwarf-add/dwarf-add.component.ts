import {Component, OnInit} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgIf} from "@angular/common";
import {DwarfService} from "../../service/dwarf.service";
import {ActivatedRoute, Router} from "@angular/router";
import {v4 as uuidv4} from "uuid"
import {DwarfForm} from "../../model/dwarf-form";
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
export class DwarfAddComponent implements OnInit {
  dwarf: DwarfForm | undefined;
  constructor(
    private dwarfService: DwarfService,
    private router: Router
  ) {
  }

  ngOnInit():void{
    this.dwarf = {
      name:"",
      voicePitch: 0
    }
  }
  onSubmit(): void {
    this.dwarfService.putDwarf(uuidv4() ,this.dwarf!)
      .subscribe(() => this.router.navigate(['/dwarves']));
  }
}
