import { Injectable } from '@angular/core';
import { Contact } from './model/contact';
@Injectable({
  providedIn: 'root'
})
export class ContactServiceService {

  contacts: Contact[];
  gents:Contact[];
  ladies:Contact[];
  constructor() {
    this.contacts=[];
    this.gents=[];
    this.ladies=[];
   }

   getList(){
     return this.contacts;
   }

  /*Adds Contact to the arrays*/
  add(contact:Contact){
    if(contact.gender=="Lady")
      this.ladies.push(contact);
    else if(contact.gender=="Gent")
      this.gents.push(contact);

    this.contacts.push(contact);
    
  }
  /*Return No. of gents*/
  getGent(){
    return this.gents;
  }

  /*Returns no. of ladies*/
  getLady(){
    return this.ladies;
  }

};
