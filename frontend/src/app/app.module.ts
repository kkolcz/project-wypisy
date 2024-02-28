import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { HeaderComponent } from './components/header/header.component';
import { NavbarComponent } from './components/header/navbar/navbar.component';
import { ProductsComponent } from './components/products/products.component';
import { ResourcesComponent } from './components/resources/resources.component';
import { ProcessesComponent } from './components/processes/processes.component';
import { ProductsAddComponent } from './components/products/products-add/products-add.component';
import { ProductsDatabaseComponent } from './components/products/products-database/products-database.component';
import { ResourcesAddComponent } from './components/resources/resources-add/resources-add.component';
import { ResourcesDatabaseComponent } from './components/resources/resources-database/resources-database.component';
import { ProcessesAddComponent } from './components/processes/processes-add/processes-add.component';
import { ProcessesDatabaseComponent } from './components/processes/processes-database/processes-database.component';
import { PrescriptionsComponent } from './components/prescriptions/prescriptions.component';
import { PrescriptionsAddComponent } from './components/prescriptions/prescriptions-add/prescriptions-add.component';
import { PrescriptionsDatabaseComponent } from './components/prescriptions/prescriptions-database/prescriptions-database.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    HeaderComponent,
    NavbarComponent,
    ProductsComponent,
    ResourcesComponent,
    ProcessesComponent,
    ProductsAddComponent,
    ProductsDatabaseComponent,
    ResourcesAddComponent,
    ResourcesDatabaseComponent,
    ProcessesAddComponent,
    ProcessesDatabaseComponent,
    PrescriptionsComponent,
    PrescriptionsAddComponent,
    PrescriptionsDatabaseComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, FormsModule, ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
