import {RouterModule, Routes} from '@angular/router';
import {DwarfListComponent} from "./dwarf/view/dwarf-list/dwarf-list.component";
import {DwarfViewComponent} from "./dwarf/view/dwarf-view/dwarf-view.component";
import {DwarfEditComponent} from "./dwarf/view/dwarf-edit/dwarf-edit.component";
import {NgModule} from "@angular/core";
import {DwarfAddComponent} from "./dwarf/view/dwarf-add/dwarf-add.component";
import {WeaponAddComponent} from "./weapon/view/weapon-add/weapon-add.component";

export const routes: Routes = [
  {
    component: DwarfListComponent,
    path: "dwarves"
  },
  {
    component: DwarfAddComponent,
    path: "dwarves/add"
  },
  {
    component: DwarfViewComponent,
    path: "dwarves/:uuid"
  }
  ,
  {
    component: DwarfEditComponent,
    path: "dwarves/:uuid/edit"
  },
  {
    component: WeaponAddComponent,
    path: "dwarves/:uuid/add"
  }



];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule {

}
