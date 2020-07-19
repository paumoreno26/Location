import { NgModule, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home/home.component';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { MaterialModule } from '../material/material.module';



@NgModule({
  declarations: [HomeComponent],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    MaterialModule
  ],
  exports: [HomeComponent]
})
export class ComponentsModule{

}
