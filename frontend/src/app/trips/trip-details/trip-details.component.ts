import { Component, OnInit } from '@angular/core';

import { Router, ActivatedRoute } from '@angular/router';

import { TripsService } from '../../services/trips/trips.service';
import { OrdersService } from '../../services/orders/orders.service';
import { UsersService } from '../../services/users/users.service';
import { AuthService } from '../../services/auth/auth.service';
import { Trip } from '../../models/trip.model';
import { User } from '../../models/user.model';
import { Order} from '../../models/order.model';

declare let $: any;

@Component({
  selector: 'app-trip-details',
  templateUrl: './trip-details.component.html',
  styleUrls: ['./trip-details.component.css'],
  providers: [TripsService, UsersService]
})
export class TripDetailsComponent implements OnInit {

  private currentTrip: Trip;
  private currentUser: User;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private tripsService: TripsService,
    private ordersService: OrdersService,
    private authService: AuthService,
    private usersService: UsersService
  ) {
    this.currentTrip = new Trip();
    this.currentUser = new User();
  }

  ngOnInit() {
    $('html, body').animate({scrollTop: $('.buy-now').offset().top - 100 + 'px'}, 'fast');
    $('select').material_select();
    $('.collapsible').collapsible();
    
    let tripId = +this.route.snapshot.params['id'];
    let userId = this.authService.getUserId();

    this.tripsService.getTripById(tripId)
      .subscribe(trip => {
        this.currentTrip = trip;
      }, error => {
        console.error(error);
      });

    if(userId) {
      this.usersService.getById(userId)
        .subscribe(user => {
          this.currentUser = user;
        }, error => {
          console.error(error);
        });
    }

  }

  onBuy() {
    let order = new Order();
    let userId = this.authService.getUserId();

    if(userId) {
      order.user = new User(this.authService.getUserId());
    } else {
      order.user = this.currentUser;
    }

    order.trip = this.currentTrip;
    order.payDate = new Date();

    this.ordersService.addToShoppingCart(order);
    this.router.navigate(['/orders/']);
  }

}
