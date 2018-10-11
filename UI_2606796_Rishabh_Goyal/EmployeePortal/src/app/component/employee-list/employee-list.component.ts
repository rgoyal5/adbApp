import { Component, OnInit } from '@angular/core';
import { Employee } from '../../model/employee';
import { EmployeeServiceService } from '../../service/employee-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees:Employee[];
  
  ladyLogo:string;
  gentLogo:string;

  constructor(
    private employeeService:EmployeeServiceService
, private activatedRoute : ActivatedRoute  ) {
    this.ladyLogo="/assets/images/lady.png";
    this.gentLogo="/assets/images/gent.png";
   }

  ngOnInit() {
    this.activatedRoute.queryParams.subscribe(
      (params) =>{
        let field = params['field'];
        let srchValue = params['srchValue'];

        console.log(field +":"+srchValue);

        if(field && srchValue){
          this.employeeService.searchEmployees(field,srchValue).subscribe(
            (data) => this.employees=data
          );
        }else{
          this.employeeService.getAllEmployees().subscribe(
            (data) => this.employees=data
          );
        }
      }
    );
}
}
