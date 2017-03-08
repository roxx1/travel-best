import { Component, OnInit } from '@angular/core';

import { Order } from '../models/order.model';
import { OrdersService } from '../services/orders/orders.service';

declare let $: any;

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  private orders: Array<Order>;
  private paidOrders: Array<Order>;

  constructor(private ordersService: OrdersService) { }

  ngOnInit() {
    $('html, body').animate({scrollTop: $('.orders').offset().top - 100 + 'px'}, 'fast');
    this.orders = this.ordersService.getAllFromShoppingCart();
  } 

  onDiscard(order: Order) {
    this.orders = this.ordersService.deleteFromShoppingCart(order);
  }

  onPay(order: Order) {
  }

  onReject(order: Order) {
  }

}
