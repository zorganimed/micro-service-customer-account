import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-customers',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './customers.component.html',
  styleUrl: './customers.component.css'
})
export class CustomersComponent implements OnInit{
  public customers: any;
   constructor(private http:HttpClient) {
   }
  ngOnInit(): void {
     this.http.get("http://localhost:8222/CUSTOMER/api/v1/customers").subscribe({
       next:data => {
         this.customers = data;
       },
       error:err => {
         console.log(err);
       }
     })
       }

}
