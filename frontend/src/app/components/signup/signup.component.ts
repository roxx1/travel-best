import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../../services/auth/auth.service';
import { User } from '../../models/user.model';

declare let $: any;

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  private user: User;
  private password: string;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
    this.user = new User();
    this.password = "";
  }

  ngOnInit() {
    $('html, body').animate({
      scrollTop: $('.signup').offset().top - 100 + 'px'
    }, 'fast');
  }

  signup() {
    this.authService.signUp(this.user.username, this.user.email, this.password)
      .subscribe(res => {
        this.router.navigate(['/trips']);
      }, error => {
        console.error(error);
      });
  }

  reset() {
    this.user = new User();
    this.password = "";
  }

}
