import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
/**
* Interceptor will validate frontend token with backend token for particular result
* if it get validate then it will provide the request result 
* if not then it will provide authentication error
* For all the request it will go through interceptor
*/
export class InterceptorServiceService implements HttpInterceptor {

  constructor() { }
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (req.url.endsWith("/login")) {
      return next.handle(req);
    }
    let token = (localStorage.getItem('jwtToken'))!
    let tokenreq = req.clone({
      setHeaders: {
        Authorization: "Bearer " + token
      }
    });
    console.log(tokenreq);
    return next.handle(tokenreq);


  }

}
