import { PalindromeComponent } from './pali-component/pali-component.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ArrayComponent } from './array/array.component';


@NgModule({
  declarations: [
    AppComponent,
    PalindromeComponent,
    ArrayComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }