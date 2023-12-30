import {RouterModule, Routes} from '@angular/router';
import {DwarfListComponent} from "./dwarf/view/dwarf-list/dwarf-list.component";
import {DwarfViewComponent} from "./dwarf/view/dwarf-view/dwarf-view.component";
import {DwarfEditComponent} from "./dwarf/view/dwarf-edit/dwarf-edit.component";
import {NgModule} from "@angular/core";

export const routes: Routes = [
  {
    component: DwarfListComponent,
    path: "dwarves"
  },
  {
    component: DwarfViewComponent,
    path: "dwarves/:uuid"
  }
  ,
  {
    component: DwarfEditComponent,
    path: "dwarves/:uuid/edit"
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
