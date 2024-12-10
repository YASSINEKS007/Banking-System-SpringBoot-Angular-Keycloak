import {Component, OnInit} from '@angular/core';
import {ProductItem} from "../models/ProductItem.model";
import {BillsService} from "../services/bills.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-bills',
  templateUrl: './bills.component.html',
  styleUrl: './bills.component.css'
})
export class BillsComponent implements OnInit {
  userId!: number;
  customerName!: string;
  customerEmail!: string;
  orderStatus!: string;
  displayedColumns: string[] = ['productName', 'priceBeforeDiscount', 'quantity', 'discount', 'totalPriceAfterDiscount'];
  dataSource: any[] = [];

  constructor(private billsService: BillsService,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    this.route.paramMap.subscribe(params => {
      const userIdString = params.get('id');
      if (userIdString) {
        this.userId = +userIdString;
      }
      this.loadBillsByCustomerId(this.userId);
    });
  }

  loadBillsByCustomerId(id: number) {
    this.billsService.loadBillsByCustomerId(id).subscribe({
      next: (data: any[]) => {
        console.log(data);
        if (data.length > 0) {
          this.customerEmail = data[0]["customer"]["email"];
          this.customerName = data[0]["customer"]["name"];
          this.orderStatus = data[0]["orderStatus"];

          this.dataSource = [];

          const productItems: ProductItem[] = data[0]["productItems"];
          productItems.forEach((item: ProductItem) => {
            const priceBeforeDiscount = item.product.price;
            const discount = item.discount;
            const quantity = item.quantity;

            const totalPriceAfterDiscount = priceBeforeDiscount * ((discount / 100));

            // Push the calculated values into dataSource
            this.dataSource.push({
              productName: item.product.name,
              priceBeforeDiscount: priceBeforeDiscount,
              quantity: quantity,
              discount: discount,
              totalPriceAfterDiscount: totalPriceAfterDiscount,
            });
          });
        } else {
          console.log('No bills found for this customer.');
        }
      },
      error: error => {
        console.log(error);
      }
    });
  }


}
