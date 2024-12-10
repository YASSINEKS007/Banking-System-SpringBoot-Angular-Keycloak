import {Component, OnInit} from '@angular/core';
import {CustomersService} from "../services/customers.service";
import {Customer} from "../models/Customer.model";

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit {
  displayedColumns: string[] = ['id', 'fullName', 'email', "bills"];
  dataSource: Customer[] = [];

  constructor(private customersService: CustomersService) {
  }

  ngOnInit() {
    this.loadCustomers();
  }

  loadCustomers() {
    this.customersService.loadCustomers().subscribe(
      {
        next: (data: Customer[]) => {
          this.dataSource = data;
          console.log(data);
        },
        error: error => {
          console.log(error);
        }
      }
    );
  }
}
