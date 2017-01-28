import { Component, OnInit } from '@angular/core';

import { Order } from '../models/order.model';

declare let $: any;

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  private orders: Array<Order>;
  private paidOrders: Array<Order>;

  constructor() { }

  ngOnInit() {
    $('html, body').animate({scrollTop: $('.orders').offset().top - 100 + 'px'}, 'fast');
    this.orders = [
      new Order(),
      new Order(),
      new Order()
    ];

    this.paidOrders = [
      new Order(),
      new Order(),
      new Order()
    ]
  }

  delete(order: Order) {
    this.orders = this.orders.filter(o => o !== order);
  }

  pay(order: Order) {

  }

  reject(order: Order) {
    this.paidOrders = this.paidOrders.filter(o => o !== order);
  }

}
