import {Injectable} from '@angular/core';
import {NubanModel} from './nuban';
import {Observable} from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {NgToastService} from 'ng-angular-popup';
import {environment} from "../environments/environment";


const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json',
  }),
};

@Injectable({
  providedIn: 'root',
})
export class AppService {
  private apiUrl = environment.apiUrl;

  constructor(private http: HttpClient, private toast: NgToastService) {
  }

  getNubans() {
    return this.http.get(this.apiUrl + 'nubans');
  }


  generateNuban(nuban: NubanModel): Observable<NubanModel> {
    return this.http.post<NubanModel>(this.apiUrl + 'generate', nuban, httpOptions);

  }


  notifySuccess(message: string): void {
    this.toast.success({
      detail: 'Success',
      summary: message,
      // sticky: true,
      position: 'tr',
      duration: 3000,
    });
  }

  notifyInfo(message: string): void {
    this.toast.info({
      detail: 'Info',
      summary: message,
      // sticky: true,
      position: 'tr',
      duration: 3000,
    });
  }

  notifyWarning(message: string): void {
    this.toast.warning({
      detail: 'Warning',
      summary: message,
      // sticky: true,
      position: 'tr',
      duration: 3000,
    });
  }

  notifyError(message: string): void {
    this.toast.error({
      detail: 'Error occurred',
      summary: message,
      // sticky: true,
      position: 'tr',
      duration: 3000,
    });
  }
}
