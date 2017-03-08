import { Component, OnInit } from '@angular/core';

import { AuthService } from '../services/auth/auth.service';
import { OrdersService } from '../services/orders/orders.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  constructor(
    private authService: AuthService,
    private ordersService: OrdersService
  ) {}

  ngOnInit() {}

  logout() {
    this.authService.logout();
  }

  hasAnyOrders() {
    return this.ordersService.getAllFromShoppingCart().length > 0;
  }

  getNumberOfOrders() {
    return this.ordersService.getAllFromShoppingCart().length;
  }

}
