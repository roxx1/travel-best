import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Order } from '../../models/order.model';
import { OrdersService } from '../../services/orders/orders.service';

declare let $: any;

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  private orders: Array<Order>;
  private paidOrders: Array<Order>;

  constructor(
    private ordersService: OrdersService,
    private router: Router
  ) {
    this.orders = [];
    this.paidOrders = [];
  }

  ngOnInit() {
    $('html, body').animate({scrollTop: $('.orders').offset().top - 100 + 'px'}, 'fast');
    this.orders = this.ordersService.getAllFromShoppingCart();
  } 

  jumpToTrip(order: Order) {
    this.router.navigate(['/trips/', order.trip.id]);
  }

  hasAnyOrders() {
    return this.orders.length > 0;
  }

  hasAnyPaidOrders() {
    return this.paidOrders.length > 0;
  }

  onDiscard(order: Order) {
    this.orders = this.ordersService.deleteFromShoppingCart(order);
  }

  onPay(order: Order) {
    this.ordersService.approve(order)
      .subscribe(order => {
        console.log("SUCCESS: " + order);
        this.ordersService.getAll().subscribe(
          orders => this.paidOrders = orders,
          error => console.error(error)
        );
      }, error => {
        console.error(error);
      });
  }

  onReject(order: Order) {
    this.ordersService.reject(order)
      .subscribe(order => {
        console.log("REJECTED: " + order);
        this.ordersService.getAll().subscribe(
          orders => this.paidOrders = orders,
          error => console.error(error)
        );
      }, error => {
        console.error(error);
      });
  }

}
