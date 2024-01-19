import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app.routes';
import { AppComponent } from './app.component';
import { NavComponent } from './component/nav/nav.component';
import { MainComponent } from './component/main/main.component';
import { HttpClientModule } from "@angular/common/http";

import { FormsModule } from "@angular/forms";
import {DwarfListComponent} from "./dwarf/view/dwarf-list/dwarf-list.component";
import {DwarfEditComponent} from "./dwarf/view/dwarf-edit/dwarf-edit.component";
import {DwarfViewComponent} from "./dwarf/view/dwarf-view/dwarf-view.component";
import {DwarfService} from "./dwarf/service/dwarf.service";

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    MainComponent,
    DwarfListComponent,
    DwarfEditComponent,
    DwarfViewComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    DwarfService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule {

}
