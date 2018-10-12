import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule} from '@angular/forms';

import { HttpModule} from '@angular/http';

import { RouterModule, Routes} from '@angular/router';

import { AppComponent } from './app.component';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { EmployeeViewComponent } from './components/employee-view/employee-view.component';
import { EmployeeFormComponent } from './components/employee-form/employee-form.component';

const paths : Routes=[
  {path: '' , component:EmployeeListComponent  },
  {path:'view/:bcode',component:EmployeeViewComponent},
  {path: 'add' , component:EmployeeFormComponent },
  {path: 'edit/:eid' , component:EmployeeFormComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    EmployeeListComponent,
    EmployeeViewComponent,
    EmployeeFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
