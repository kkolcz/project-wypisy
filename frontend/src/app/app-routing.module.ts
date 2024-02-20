import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ProductsComponent } from './components/products/products.component';
import { ProductsAddComponent } from './components/products/products-add/products-add.component';
import { ProductsDatabaseComponent } from './components/products/products-database/products-database.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  {
    path: 'products',
    component: ProductsComponent,
    children: [
      { path: 'add', component: ProductsAddComponent },
      { path: 'database', component: ProductsDatabaseComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
