import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'app-accounts',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './accounts.component.html',
  styleUrl: './accounts.component.css'
})
export class AccountsComponent implements OnInit{
  public accounts: any;
  constructor(private http:HttpClient) {
  }
  ngOnInit(): void {
    this.http.get("http://localhost:8222/ACCOUNT/api/v1/accounts/customers").subscribe({
      next:data => {
        this.accounts = data;
      },
      error :err =>{
        console.log(err);
      }
    })
  }

}
