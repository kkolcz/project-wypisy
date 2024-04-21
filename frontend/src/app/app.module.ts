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
