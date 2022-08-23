import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutModuleComponent } from './about-module/about-module.component';
import { AuthGuardGuard } from './auth-guard.guard';
import { ClaimInputComponent } from './claim-input/claim-input.component';
import { ClaimOutputComponent } from './claim-output/claim-output.component';
import { ContactModuleComponent } from './contact-module/contact-module.component';
import { ErrormsgComponent } from './errormsg/errormsg.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { LoginModuleComponent } from './login-module/login-module.component';
import { MemberModuleComponent } from './member-module/member-module.component';
import { Memberdet1Component } from './memberdet1/memberdet1.component';
import { MemberdetailsModuleComponent } from './memberdetails-module/memberdetails-module.component';
import { SubmitInputComponent } from './submit-input/submit-input.component';
import { SubmitOutputComponent } from './submit-output/submit-output.component';

const routes: Routes = [
  { path: 'loginModule', component: LoginModuleComponent },
  { path: 'memberModule', component: MemberModuleComponent, canActivate: [AuthGuardGuard] },
  { path: 'contactModule', component: ContactModuleComponent, canActivate: [AuthGuardGuard] },
  { path: 'memberdetailsModule', component: MemberdetailsModuleComponent, canActivate: [AuthGuardGuard] },
  { path: 'memberdet1Module', component: Memberdet1Component },
  { path: 'claimInput', component: ClaimInputComponent, canActivate: [AuthGuardGuard] },
  { path: 'claimOutput', component: ClaimOutputComponent },
  { path: 'submitInput', component: SubmitInputComponent, canActivate: [AuthGuardGuard] },
  { path: 'submitOutput', component: SubmitOutputComponent },
  { path: 'error', component: ErrormsgComponent },
  { path: '', redirectTo: '/loginModule', pathMatch: 'full' },
  {path :'header',component :HeaderComponent},
  {path :'footer',component :FooterComponent},
  {path :'aboutModule',component :AboutModuleComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [LoginModuleComponent, MemberModuleComponent,
  ContactModuleComponent, MemberdetailsModuleComponent, Memberdet1Component, ClaimInputComponent,
  ClaimOutputComponent, SubmitInputComponent,HeaderComponent,FooterComponent,AboutModuleComponent]