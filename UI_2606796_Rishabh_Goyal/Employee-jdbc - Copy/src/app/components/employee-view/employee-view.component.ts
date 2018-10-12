import { Component, OnInit } from '@angular/core';

import { EmployeeService } from '../../service/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../../model/employee';

@Component({
  selector: 'app-employee-view',
  templateUrl: './employee-view.component.html',
  styleUrls: ['./employee-view.component.css']
})
export class EmployeeViewComponent implements OnInit {

  employee:Employee;
  constructor(
              private employeeService:EmployeeService,
              private activatedRoute:ActivatedRoute,
              private router:Router
  ) { }

  ngOnInit() {
  
  this.activatedRoute.params.subscribe(
    (params)=>{
      let eid = params['eid'];
      this.employeeService.getEmployee(eid).subscribe(
        (data)=>this.employee=data
      );
    }
  );

}
doDelete(){
  if(confirm("Are You Fucking Sure?")){
    this,this.employeeService.delete(this.employee.eid).subscribe(
      (resp)=>{
        if(resp.ok){
          this.router.navigateByUrl("/");
        }
      }
    );
  }
}

doEdit(){
  this.router.navigateByUrl("/edit/"+this.employee.eid);
}
}