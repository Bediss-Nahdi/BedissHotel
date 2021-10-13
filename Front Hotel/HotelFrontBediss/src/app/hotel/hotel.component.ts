import { Component, OnInit, ViewChild } from '@angular/core';
import { Hotel } from '../entities/hotel';
import { HotelService } from '../service/hotel.service';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css']
})
export class HotelComponent implements OnInit {
  hotel : Hotel = new Hotel();
  hotels: Array<Hotel> = [];

  @ViewChild( 'closebutton' ) closebuttonelement: any;
  
  success : boolean = false;
  error : boolean = false;
  search : string = "";

  constructor(public hotelService : HotelService) { }

  ngOnInit(): void {
    this.loadHotel();
  }

  loadHotel() {
    this.hotelService.loadHotels(this.search).subscribe(
      data => {
        this.hotels = data;
      }
    );
  }

  delete(id? : number): void
  {
    if (confirm("Êtest-vous sûr de vouloir supprimer cet hotel ?")){
      this.hotelService.deleteHotel(id).subscribe(
        data => {
          this.loadHotel();
          this.success = true;
        }
      );
    }
  }

  resetForm(){
    this.error = false;
    this.success = false;
    this.hotel = new Hotel();
  }

  edit(id? : number): void
  {
    this.hotelService.getHotel(id).subscribe(
      data => {
        this.hotel = data;
        this.success = true;
      }
    );
  }

  submitForm(): void
  {
    if (this.hotel.id == undefined){
      this.hotelService.addHotel(this.hotel).subscribe(
        data => {
          this.closebuttonelement.nativeElement.click();
          this.loadHotel();
          this.success = true;
        }, error => {
          this.error = true;
        }
      )
    }else {
      this.hotelService.editHotel(this.hotel).subscribe(
        data => {
          this.closebuttonelement.nativeElement.click();
          this.loadHotel();
          this.success = true;
        }, error => {
          this.error = true;
        }
      );
    }
  }
}
