import {Component, OnInit} from '@angular/core';
import {DwarfDetails} from "../../model/dwarf-details";
import {DwarfService} from "../../service/dwarf.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-dwarf-view',
  templateUrl: './dwarf-view.component.html',
  styleUrl: './dwarf-view.component.css'
})
export class DwarfViewComponent implements OnInit{
  dwarf: DwarfDetails | undefined;

  constructor(private service: DwarfService, private route: ActivatedRoute, private router: Router) {
  }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.service.getDwarf(params['uuid'])
        .subscribe(dwarf => this.dwarf = dwarf)
    });
  }
}
