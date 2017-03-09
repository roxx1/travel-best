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

import { environment } from '../../../environments/environment';

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
    let userId = this.authService.getUserId() || 0;
    return this.http.get(`${environment.host}api/orders?userId=${userId}`)
      .map((res: Response) => {
        return res.json()._embedded.orders || [];
      }).catch(error => {
        throw Error(error.json() && error.json().message);
      });
  }

  approve(order: Order) {
    console.log(order);
    return this.http.post(
      `${environment.host}api/orders/`,
      this.generateOptions(),
      order
    ).map((res: Response) => {
      return this.deleteFromShoppingCart(order);
    }).catch(error => {
      throw Error(error.json() && error.json().message);
    });
  }

  reject(order: Order) {
    return this.http.patch(
      `${environment.host}api/orders/${order.id}/reject`,
      this.generateOptions(),
      order
    ).map((res: Response) => {
      return res.json();
    }).catch(error => {
      throw Error(error.json() && error.json().message);
    });
  }

  private generateOptions(): RequestOptions {
    let headers = new Headers({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      'Access-Control-Allow-Credentials': true,
      'Authorization': this.authService.getToken()
    });
    return new RequestOptions({ headers: headers });
  }

}
