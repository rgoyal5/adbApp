import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Employee } from '../model/employee';

@Component({
  selector: 'app-employee-table',
  templateUrl: './employee-table.component.html',
  styleUrls: ['./employee-table.component.css']
})
export class EmployeeTableComponent implements OnInit {

  employees:Employee[];
  constructor( private data : DataService) { }

  ngOnInit() {

    this.employees=this.data.getAllItems();
  }

}
