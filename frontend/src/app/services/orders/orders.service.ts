import { Injectable } from '@angular/core';

import {
  Http,
  Headers,
  RequestOptions,
  Response
} from '@angular/http';

import { Observable, ReplaySubject } from 'rxjs/Rx';
import 'rxjs/add/operator/map'

import { AuthService } from "../auth/auth.service";
import { Order } from "../../models/order.model";
import { User } from "../../models/user.model";

@Injectable()
export class OrdersService {

  private static generatedOrderId = 1;

  constructor(
    private http: Http,
    private authService: AuthService
  ) {
    if(!localStorage.getItem("orders")) {
      localStorage.setItem("orders", JSON.stringify([]));
    }
  }
  
  addToShoppingCart(order: Order): Array<Order> {
    order.id = OrdersService.generatedOrderId++;
    let orders = JSON.parse(localStorage.getItem("orders"));
    orders.push(order);
    localStorage.setItem("orders", JSON.stringify(orders));
    return orders;
  }

  deleteFromShoppingCart(order: Order): Array<Order> {
    let orders = JSON.parse(localStorage.getItem("orders"));
    orders = orders.filter(o => o.id !== order.id);
    localStorage.setItem("orders", JSON.stringify(orders));
    return orders;
  }

  getAllFromShoppingCart(): Array<Order> {
    return JSON.parse(localStorage.getItem("orders"));
  }

  getAll(): Observable<Array<Order>> {
    // TODO
    return null;
  }

  approve(order: Order) {
    // TODO
  }

  reject(order: Order) {
    // TODO
  }

}
