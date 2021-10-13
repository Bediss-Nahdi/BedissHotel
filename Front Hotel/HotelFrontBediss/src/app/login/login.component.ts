import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../service/admin.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  error : boolean = false;

  admin = {
    username: "",
    password: ""
  };

  constructor(private adminService : AdminService, private router : Router) { }

  ngOnInit(): void {
  }
  authenticate() {
    console.log("test");
    
    this.adminService.authenticate(this.admin).subscribe(
      data => {
        console.log(data)
        if (data.id > 0) {
          sessionStorage.setItem("connectedUser" , data );
          console.log("redirection");
          this.router.navigate(['resa'])
        }else{
          this.error = true;
        }
      } ,
      error => {
        this.error = true;
      }
    );
  }
}