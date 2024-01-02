import {Component, OnInit} from '@angular/core';
import {DwarfForm} from "../../model/dwarf-form";
import {Weapons} from "../../../weapon/model/weapons";
import {DwarfService} from "../../service/dwarf.service";
import {WeaponService} from "../../../weapon/service/weapon.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-dwarf-edit',
  templateUrl: './dwarf-edit.component.html',
  styleUrl: './dwarf-edit.component.css'
})
export class DwarfEditComponent implements OnInit{
  uuid: string | undefined;
  dwarf: DwarfForm |undefined;
  original: DwarfForm | undefined;

  constructor(
    private dwarfService: DwarfService,
    private route: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
   //   console.log(params['uuid'])
      this.dwarfService.getDwarf(params['uuid'])
        .subscribe(dwarf => {
          this.uuid = params['uuid'] //dwarf.id;
          this.dwarf = {
            name: dwarf.name,
            voicePitch: dwarf.voicePitch,
          };
          this.original = {...this.dwarf};
        });
    });
  }
  onSubmit(): void {
    this.dwarfService.putDwarf(this.uuid!, this.dwarf!)
      .subscribe(() => this.router.navigate(['/dwarves']));
  }

}
