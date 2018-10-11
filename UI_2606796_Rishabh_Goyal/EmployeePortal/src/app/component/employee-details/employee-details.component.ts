import { Component, OnInit } from '@angular/core';
import { Employee } from '../../model/employee';
import { EmployeeServiceService } from '../../service/employee-service.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
  employee:Employee;
  ladyLogo: string;
  gentLogo: string;
  constructor(private employeeService:EmployeeServiceService,
    private activatedRoute: ActivatedRoute
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
}
