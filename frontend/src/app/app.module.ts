import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';

import { Ng2PaginationModule } from 'ng2-pagination';

import { AppComponent } from './app.component';
import { TripsComponent } from './trips/trips.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { NavComponent } from './nav/nav.component';
import { OrdersComponent } from './orders/orders.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { TripDetailsComponent } from './trips/trip-details/trip-details.component';

import { SearchPipe } from './pipes/search.pipe';
import { AuthService } from './services/auth/auth.service';
import { OrdersService } from './services/orders/orders.service';

@NgModule({
  declarations: [
    AppComponent,
    TripsComponent,
    HeaderComponent,
    FooterComponent,
    NavComponent,
    OrdersComponent,
    LoginComponent,
    SignupComponent,
    TripDetailsComponent,
    SearchPipe,
    SearchPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot([
      {path: "orders", component: OrdersComponent},
      {path: "login", component: LoginComponent},
      {path: "signup", component: SignupComponent},
      {path: "trips", component: TripsComponent},
      {path: "trips/:id", component: TripDetailsComponent},
      {path: "", component: TripsComponent},
      {path: "**/*", component: AppComponent},
    ]),
    Ng2PaginationModule
  ],
  providers: [
    AuthService, OrdersService
  ],
  bootstrap: [
    AppComponent
  ]
})
export class AppModule { }
