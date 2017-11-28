import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { User } from './user';
import { AppComponent } from './app.component';
import { LoginComponent } from './login.component';
import {HomeComponent} from './home.component';
import { FormsModule }   from '@angular/forms';
import { HttpModule } from '@angular/http';
import {AppRoutingModule} from './app-routing.module';
import {AuthGuard} from './auth-guard.service';
import {BackEndService} from './backend-service';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule
  ],
  providers: [AuthGuard,BackEndService],
  bootstrap: [AppComponent]
})
export class AppModule { }
