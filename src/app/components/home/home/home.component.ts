import { Component, OnInit, DebugElement } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LocationService } from 'src/app/core/services/location.service';
import { Generic } from 'src/app/core/models/genericResponse';
import { Children } from 'src/app/core/models/children';
import { Parent } from 'src/app/core/models/parent';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  public formGroup: FormGroup;
  public formGroupChildren:FormGroup;
  public locationParent: Generic<Parent[]>;
  public locationChild: Generic<Children[]>;
  public data: Children;
  public parent: Parent;
  public children = false;
  public idChildren : number;
  constructor(
    private formBuilder: FormBuilder,
    private FormBuilderChildren: FormBuilder,
    private locationService: LocationService
  ){

  }
  ngOnInit(): void {
    this.data = new Children();
    this.loadValidations();
    this.parent = new Parent();
    this.loadParent();
  }

  loadValidations(){

    this.formGroup = this.formBuilder.group(
      {
        name:["",Validators.required],
        area: ["", Validators.required]
      }
    )

  }



  loadParent(){
    this.locationService.loadParent().subscribe(res => {
      this.locationParent = res;
      console.log("resultado", this.locationParent);
    })
  }

  loadChildren(id:number){
    debugger
    this.locationService.loadChildren(id).subscribe(res => {
      this.locationChild = res;
      console.log("resultado", this.locationParent);
    })
  }

  addChildren(id:number){
    this.children =true;
    this.idChildren = id;
  }
  
  sendChildren(){
    this.setValues(this.idChildren);
    this.locationService.addCHildren(this.data).subscribe(res =>{
      console.log("datos enviados", res)
    })
  }

  setValues(id:number){
    debugger
    this.data.name = this.formGroupChildren.value.name;
    this.data.area = this.formGroupChildren.value.area;
    this.data.parent = id;

  }

  onSubmit(){
    debugger
    this.parent.name = this.formGroup.value.name;
    this.parent.area = this.formGroup.value.area;
    this.locationService.addParent(this.parent).subscribe(res =>{
      console.log("datos enviados", res)
      this.loadParent();

    })
  }

  delete(id:number){
    this.locationService.deleteParent(id).subscribe(res =>{
      console.log("Eliminado", res)
      this.loadParent();
    })
  }
}
