import {Component} from '@angular/core';
import {AppService} from "./app.service";
import {NubanModel} from "./nuban";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'NubanFrontend';
  name: string = "IDAN";
  bankCode: string = "";
  serialNumber: string = "";
  showResult: boolean = false;
  newNuban: NubanModel = {bankCode: "", serialNumber: "", nubanNumber: ""};


  constructor(private service: AppService) {
  }


  onClickSubmit() {

    // check bank code length
    if (this.bankCode.length != 3) {
      this.service.notifyWarning("Bank code must be 3 digits");
      return;
    }


    // check serial number length
    if (this.serialNumber.length >= 10 || this.serialNumber.length < 0) {
      this.service.notifyWarning("Serial number must be between 1 and 9 digits");
      return;
    }

    // Check if the bank code is valid number
    if (isNaN(Number(this.bankCode))) {
      this.service.notifyWarning("Bank code must be a number");
      return;
    }

    // Check if the serial number is valid number
    if (isNaN(Number(this.serialNumber))) {
      this.service.notifyWarning("Serial number must be a number");
      return;
    }
    let nuban: NubanModel = {bankCode: this.bankCode, serialNumber: this.serialNumber, nubanNumber: ""};

    // get nuban number
    this.service.generateNuban(nuban).subscribe(response => {

      // show result
      this.newNuban.bankCode = response.bankCode;
      this.newNuban.serialNumber = response.serialNumber;
      this.newNuban.nubanNumber = response.nubanNumber;
      this.showResult = true;

      this.service.notifySuccess("Nuban generated successfully");

      // reset form
      this.resetForm();
    }, error => {
      // console.log(error)
      this.service.notifyError("An error occurred!!! Try again.");
    });
  }

  resetForm() {
    this.bankCode = "";
    this.serialNumber = "";
  }

  closeResult() {
    this.showResult = false;
  }

}
