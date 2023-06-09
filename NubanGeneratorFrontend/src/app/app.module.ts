import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {NgIf} from "@angular/common";
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NgToastModule} from "ng-angular-popup";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule, FormsModule, HttpClientModule, NgIf, NgbModule, NgToastModule, NgToastModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
