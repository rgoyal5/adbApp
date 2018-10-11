import { Component, OnInit } from '@angular/core';
import { Employee } from '../../model/employee';
import { EmployeeServiceService } from '../../service/employee-service.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-employee-delete',
  templateUrl: './employee-delete.component.html',
  styleUrls: ['./employee-delete.component.css']
})
export class EmployeeDeleteComponent implements OnInit {

  employee:Employee;
  ladyLogo: string;
  gentLogo: string;
  constructor(private employeeService:EmployeeServiceService,
    private activatedRoute: ActivatedRoute,
    private router : Router
  ) {
  this.ladyLogo = "/assets/images/lady.png";
    this.gentLogo = "/assets/images/gent.png";
  }

  ngOnInit() {
    this.activatedRoute.params.subscribe(
      (params) => {
        let empId = params['id'];
        if (empId) {
          this.employeeService.getEmployeeById(empId).subscribe(
            (data) => this.employee = data
          );
        }
      }
    );
  }

  doDelete(isConfirmed:boolean){
    if(isConfirmed){
      this.employeeService.deleteEmployeeById(this.employee.empId).subscribe(
        (resp) =>{
          if(resp.ok){
            this.router.navigateByUrl("/?opt=d&id="+this.employee.empId);
          }
        }
      );
    }else{
      this.router.navigateByUrl("/");
    }
  }
}
