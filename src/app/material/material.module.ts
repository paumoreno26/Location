import { CommonModule } from "@angular/common";
import { NgModule } from "@angular/core";

// Modules angular material
import { MatButtonModule } from "@angular/material/button";
import { MatCardModule } from "@angular/material/card";
import { MatCheckboxModule } from "@angular/material/checkbox";
import { MatRippleModule } from "@angular/material/core";
import { MatDialogModule } from "@angular/material/dialog";
import { MatDividerModule } from "@angular/material/divider";
import { MatExpansionModule } from "@angular/material/expansion";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatIconModule } from "@angular/material/icon";
import { MatInputModule } from "@angular/material/input";
import { MatListModule } from "@angular/material/list";
import { MatRadioModule } from "@angular/material/radio";
import { MatSelectModule } from "@angular/material/select";

@NgModule({
  declarations: [],
  exports: [
    MatButtonModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatExpansionModule,
    MatCardModule,
    MatSelectModule,
    MatListModule,
    MatDividerModule,
    MatIconModule,
    MatInputModule,
    MatDialogModule,
    MatRadioModule,
    MatRippleModule,
  ],
  imports: [
    CommonModule,
    MatButtonModule,
    MatExpansionModule,
    MatFormFieldModule,
    MatCheckboxModule,
    MatCardModule,
    MatListModule,
    MatDividerModule,
    MatSelectModule,
    MatIconModule,
    MatInputModule,
    MatDialogModule,
    MatRadioModule,
    MatRippleModule,
  ],
})
export class MaterialModule {}
