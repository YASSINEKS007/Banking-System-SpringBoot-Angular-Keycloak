import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {CustomersComponent} from "./customers/customers.component";
import {ProductsComponent} from "./products/products.component";
import {AuthGuard} from "./guards/auth.guard";
import {BillsComponent} from "./bills/bills.component";

const routes: Routes = [
  {path: 'customers', component: CustomersComponent, canActivate: [AuthGuard], data: {roles: ["ADMIN"]}},
  {path: 'products', component: ProductsComponent, canActivate: [AuthGuard], data: {roles: ["USER"]}},
  {path : 'bills/:id', component: BillsComponent, canActivate: [AuthGuard], data: {roles: ["USER"]}}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
