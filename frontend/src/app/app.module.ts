import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingPageComponent } from './components/landing-page/landing-page.component';
import { LoginComponent } from './components/login/login.component';
import { HeaderComponent } from './components/header/header.component';
import { NavbarComponent } from './components/header/navbar/navbar.component';
import { ProductsComponent } from './components/products/products.component';
import { MaterialsComponent } from './components/materials/materials.component';
import { ProcessesComponent } from './components/processes/processes.component';
import { ProductsAddComponent } from './components/products/products-add/products-add.component';
import { ProductsDatabaseComponent } from './components/products/products-database/products-database.component';
import { MaterialsAddComponent } from './components/materials/materials-add/materials-add.component';
import { MaterialsDatabaseComponent } from './components/materials/materials-database/materials-database.component';
import { ProcessesAddComponent } from './components/processes/processes-add/processes-add.component';
import { ProcessesDatabaseComponent } from './components/processes/processes-database/processes-database.component';
import { PrescriptionsComponent } from './components/prescriptions/prescriptions.component';
import { PrescriptionsAddComponent } from './components/prescriptions/prescriptions-add/prescriptions-add.component';
import { PrescriptionsDatabaseComponent } from './components/prescriptions/prescriptions-database/prescriptions-database.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ToolsComponent } from './components/tools/tools.component';
import { ToolsDatabaseComponent } from './components/tools/tools-database/tools-database.component';
import { ToolsAddComponent } from './components/tools/tools-add/tools-add.component';
import { LocationComponent } from './components/location/location.component';
import { LocationDatabaseComponent } from './components/location/location-database/location-database.component';
import { LocationAddComponent } from './components/location/location-add/location-add.component';
import { ProcesscategoryComponent } from './components/processcategory/processcategory.component';
import { ProcesscategoryDatabaseComponent } from './components/processcategory/processcategory-database/processcategory-database.component';
import { ProcesscategoryAddComponent } from './components/processcategory/processcategory-add/processcategory-add.component';
import { MachineProgramComponent } from './components/machine-program/machine-program.component';
import { MachineProgramAddComponent } from './components/machine-program/machine-program-add/machine-program-add.component';
import { MachineProgramDatabaseComponent } from './components/machine-program/machine-program-database/machine-program-database.component';
import { ProductsAddStep1Component } from './components/products/products-add/products-add-step1/products-add-step1.component';
import { ProductsAddStep2Component } from './components/products/products-add/products-add-step2/products-add-step2.component';
import { ProductsAddStep3Component } from './components/products/products-add/products-add-step3/products-add-step3.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingPageComponent,
    LoginComponent,
    HeaderComponent,
    NavbarComponent,
    ProductsComponent,
    MaterialsComponent,
    ProcessesComponent,
    ProductsAddComponent,
    ProductsDatabaseComponent,
    MaterialsAddComponent,
    MaterialsDatabaseComponent,
    ProcessesAddComponent,
    ProcessesDatabaseComponent,
    PrescriptionsComponent,
    PrescriptionsAddComponent,
    PrescriptionsDatabaseComponent,
    ToolsComponent,
    ToolsDatabaseComponent,
    ToolsAddComponent,
    LocationComponent,
    LocationDatabaseComponent,
    LocationAddComponent,
    ProcesscategoryComponent,
    ProcesscategoryDatabaseComponent,
    ProcesscategoryAddComponent,
    MachineProgramComponent,
    MachineProgramAddComponent,
    MachineProgramDatabaseComponent,
    ProductsAddStep1Component,
    ProductsAddStep2Component,
    ProductsAddStep3Component,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
