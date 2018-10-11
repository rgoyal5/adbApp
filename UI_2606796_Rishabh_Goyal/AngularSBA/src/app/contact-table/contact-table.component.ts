import { Component, OnInit } from '@angular/core';
import { Contact } from '../model/contact';
import { ContactServiceService } from '../contact-service.service';
@Component({
  selector: 'app-contact-table',
  templateUrl: './contact-table.component.html',
  styleUrls: ['./contact-table.component.css']
})
export class ContactTableComponent implements OnInit {

  contacts:Contact[];
  gents:Contact[];
  ladies:Contact[];
  constructor(
    private ser:ContactServiceService
  ) { }

  ngOnInit() {
    this.contacts=this.ser.getList();
    this.gents=this.ser.getGent();
    this.ladies=this.ser.getLady();
  }


}

