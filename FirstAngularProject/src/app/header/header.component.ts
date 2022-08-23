import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Member } from '../member';
import { MemberService } from '../member.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  key1: any;
  collapsed = true;
  show: boolean = false
  res:any;

  constructor(private _service: MemberService, private _route: Router,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.queryParams.subscribe(
      result =>{
      this.res = JSON.parse(result.data);
       console.log(JSON.parse(result.data));
      })
       this.key1 = sessionStorage.getItem("key");
       
  }

  onLogout(){
    console.log("working");
    localStorage.clear();
  }


  toggleCollapsed(): void {
    this.collapsed = !this.collapsed;
  }


}
