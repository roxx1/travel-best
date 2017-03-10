import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from '../../services/auth/auth.service';

declare let $: any;

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private username: string;
  private password: string;

  constructor(
    private authService: AuthService,
    private router: Router
  ) {
    this.username = "";
    this.password = "";
  }

  ngOnInit() {
    $('html, body').animate({
      scrollTop: $('.login').offset().top - 100 + 'px'
    }, 'fast');
  }

  signIn() {
    this.authService.signIn(this.username, this.password)
      .subscribe(res => {
        console.log(res);
        this.router.navigate(['/trips']);
      }, error => {
        console.error(error);
      });
  }

  reset() {
    this.username = "";
    this.password = "";
  }

}
