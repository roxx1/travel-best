import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { TripsService } from '../../services/trips/trips.service';
import { OrdersService } from '../../services/orders/orders.service';
import { AuthService } from '../../services/auth/auth.service';
import { Trip } from '../../models/trip.model';
import { User } from '../../models/user.model';
import { Order} from '../../models/order.model';

declare let $: any;

@Component({
  selector: 'app-trip-details',
  templateUrl: './trip-details.component.html',
  styleUrls: ['./trip-details.component.css'],
  providers: [TripsService]
})
export class TripDetailsComponent implements OnInit {

  private currentTrip: Trip;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private tripsService: TripsService,
    private ordersService: OrdersService,
    private authService: AuthService
  ) {
    this.currentTrip = new Trip();
  }

  ngOnInit() {
    $('html, body').animate({scrollTop: $('.buy-now').offset().top - 100 + 'px'}, 'fast');
    $('select').material_select();
    $('.collapsible').collapsible();
    
    let id = +this.route.snapshot.params['id'];

    this.tripsService.getTripById(id)
      .subscribe(trip => {
        this.currentTrip = trip;
      }, error => {
        console.error(error);
      });
  }

  onBuy() {
    let order = new Order();
    let userId = this.authService.getUserId();

    if(userId) {
     order.user = new User(this.authService.getUserId());
    } else {
      order.user = new User();
    }

    order.trip = this.currentTrip;
    order.payDate = new Date();

    this.ordersService.addToShoppingCart(order);
    this.router.navigate(['/orders/']);
  }

}
