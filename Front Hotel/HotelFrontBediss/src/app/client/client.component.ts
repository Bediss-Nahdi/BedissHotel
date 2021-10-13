import { Component, OnInit, ViewChild } from '@angular/core';
import { Client } from '../entities/client';
import { ClientService } from '../service/client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent implements OnInit {

  client : Client = new Client();
  clients : Array<Client> = [];

  success : boolean = false;
  error : boolean = false;
  search : string = "";
  @ViewChild( 'closebutton' ) closebuttonelement: any;

  constructor(public clientService : ClientService) { }

  ngOnInit(): void
  {
    this.loadClient();
  }

  loadClient(): void
  {
    this.clientService.loadClients(this.search).subscribe(
      data => {
        this.clients = data;
      }
    );
  }

  delete(id? : number): void
  {
    if (confirm("Êtes vous sûr de vouloir supprimer ce client ?")){
      this.clientService.deleteClient(id).subscribe(
        data => {
          this.loadClient();
          this.success = true;
        }
      );
    }
  }

  resetForm(){
    this.error = false;
    this.success = false;
    this.client = new Client();
  }

  edit(id? : number): void
  {
    console.log(id);
    this.clientService.getClient(id).subscribe(
      data => {
        this.client = data;
      }, error => {
        this.error = true;
      }
    )
  }

  submitForm(): void
  {
    if (this.client.id == undefined){
      this.clientService.addClient(this.client).subscribe(
        data => {
          this.closebuttonelement.nativeElement.click();
          this.loadClient();
          this.success = true;
        }
      )
    } else {
      this.clientService.editClient(this.client).subscribe(
        data => {
          this.closebuttonelement.nativeElement.click();
          this.loadClient();
          this.success = true;
        }, error => {
          this.error = true;
        }
      )
    }
  }

}
