import { Component, OnInit } from '@angular/core';
import { Employee } from '../../model/employee';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeServiceService } from '../../service/employee-service.service';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent implements OnInit {

  rupeeLogo: string
  employee:Employee;
  isEditing:boolean;

  constructor(
    private activatedRoute:ActivatedRoute,
    private employeeService:EmployeeServiceService,
    private router:Router
  ) { 
    this.rupeeLogo="/assets/images/rupee.jpg";
  }

  ngOnInit() {
    this.employee=new Employee();
    this.isEditing=false;

    this.activatedRoute.params.subscribe(
      (params)=>{
        let empId = params['id'];
        if(empId){
          this.employeeService.getEmployeeById(empId).subscribe(
            (data)=>{
              this.employee=data;
              this.isEditing=true;
            }
          );
        }
      }
    );
  }

  save(){
    if(this.isEditing){
      this.employeeService.updateEmployee(this.employee).subscribe(
        (data)=>{
          this.router.navigateByUrl("/?opt=u&id="+this.employee.empId);
        },
        (error)=>{alert("Your email id or mobile number already exist");}
      );
    }else{
      this.employeeService.addEmployee(this.employee).subscribe(
        (data)=>{
          this.router.navigateByUrl("/?opt=a&id="+data.empId);
        },
        (error)=>{alert("Your email id or mobile number already exist");}
      );
    }
  }
}
