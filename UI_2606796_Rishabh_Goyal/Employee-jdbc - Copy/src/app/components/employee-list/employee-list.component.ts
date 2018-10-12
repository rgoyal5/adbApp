import { Component, OnInit } from '@angular/core';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../service/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {

  employees:Employee[];
  constructor(private employeeService:EmployeeService,
              private router : Router) { }

  ngOnInit() {
    this.employeeService.getAll().subscribe(
      data=>this.employees=data
    );
  }

  showBook(eid){
    this.router.navigateByUrl("/view/"+eid);
  }

}
