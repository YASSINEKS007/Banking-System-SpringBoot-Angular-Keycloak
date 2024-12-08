import {Component, OnInit} from '@angular/core';
import {MatCell, MatColumnDef, MatHeaderCell, MatHeaderRow, MatRow, MatTableModule} from '@angular/material/table';
import {MatButtonModule} from '@angular/material/button';
import {Customer} from '../models/Customer.model';
import {CustomersService} from '../services/customers.service';
import {RouterLink} from '@angular/router';

@Component({
  selector: 'app-customers',
  imports: [
    MatTableModule,
    MatColumnDef,
    MatHeaderCell,
    MatCell,
    MatHeaderRow,
    MatRow,
    MatButtonModule,
    RouterLink
  ],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  displayedColumns: string[] = ['id', 'name', 'email'];
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
