import {
  Component,
  OnInit,
  ViewChild
} from '@angular/core';

import { Router } from '@angular/router';

import {
  PaginatePipe,
  PaginationService
} from 'ng2-pagination';

import { TripsService } from '../services/trips/trips.service';
import { OrdersService } from '../services/orders/orders.service';
import { AuthService } from '../services/auth/auth.service';

import { TripDetailsComponent } from './trip-details/trip-details.component';

import { Trip } from '../models/trip.model';
import { Order } from '../models/order.model';
import { User } from '../models/user.model';

declare let $: any;

@Component({
  selector: 'app-trips',
  templateUrl: './trips.component.html',
  styleUrls: ['./trips.component.css'],
  providers: [TripsService]
})
export class TripsComponent implements OnInit {

  @ViewChild('details') private details: TripDetailsComponent;
  private trips: Array<Trip>;
  private term: string;

  constructor(
    private router: Router,
    private tripsService: TripsService,
    private ordersService: OrdersService,
    private authService: AuthService
  ) {}

  ngOnInit() {
    $('html, body').animate({scrollTop: $('.row').offset().top + 'px'}, 'fast');

    this.term = "";

    this.tripsService.getTrips()
      .subscribe(trips => {
        this.trips = trips;
      }, error => {
        console.error(error);
      });
  }

  onBuyNow(trip: Trip) {
    this.router.navigate(['/trips/', trip.id]);
  }

  onAddToShoppingCart(trip: Trip) {
    let order = new Order();
    let userId = this.authService.getUserId();

    if(userId) {
     order.user = new User(this.authService.getUserId());
    } else {
      order.user = new User();
    }

    order.trip = trip;
    order.payDate = new Date();

    this.ordersService.addToShoppingCart(order);
  }

}
