import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule,Routes} from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import { EmployeeTableComponent } from './employee-table/employee-table.component';

const routesMap : Routes=[
  {path:'',component:EmployeeFormComponent},
  {path:'vt',component:EmployeeTableComponent},
  
  ]

@NgModule({
  declarations: [
    AppComponent,
    EmployeeFormComponent,
    EmployeeTableComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routesMap),
    FormsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})

export class AppModule { }
