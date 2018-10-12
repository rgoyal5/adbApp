import { Component, OnInit } from '@angular/core';
import { Emplyoee } from '../../model/emplyoee';
import { EmplyoeeService } from '../../service/emplyoee.service';

@Component({
  selector: 'app-emplyoee-list',
  templateUrl: './emplyoee-list.component.html',
  styleUrls: ['./emplyoee-list.component.css']
})
export class EmplyoeeListComponent implements OnInit {
  emplyoees:Emplyoee[];

  ladyLogo:string;
  gentLogo:string;
  cloudIcon : string;
  dbIcon : string;
  custIcon:string;
  javaIcon:string;

  constructor(private emplyoeeService:EmplyoeeService) {
    this.ladyLogo="/assets/images/fem.jpg";
    this.gentLogo="/assets/images/male.png";
    this.dbIcon="/assets/images/databaseLogo.png";
    this.cloudIcon="/assets/images/cloud.jpg";
    this.custIcon="/assets/images/customer.jpg";
    this.javaIcon="/assets/images/java.png";
   }

  ngOnInit() {
    this.emplyoeeService.getAllEmplyoees().subscribe(
      (data)=>this.emplyoees=data);
  }

}
