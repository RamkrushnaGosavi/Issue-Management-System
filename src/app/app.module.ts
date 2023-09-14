import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AboutComponent } from './about/about.component';
import { addIssueComponent } from './addIssue/addIssue.component';
import { addIssueGuard } from './addIssue/addIssue.guard';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EditIssueComponent } from './editIssue/editIssue.component';
import { IssueDetailsComponent } from './issueDetails/issueDetails.component';
import { IssueDetailsGuard } from './issueDetails/issueDetails.guard';
import { IssueComponent } from './issues/issue.component';
import { IssueService } from './issue.service';

@NgModule({
  declarations: [
    IssueComponent, AboutComponent, addIssueComponent, EditIssueComponent, IssueDetailsComponent, AppComponent 
  ],
  imports: [
    BrowserModule,
    AppRoutingModule, FormsModule ,HttpClientModule
  ],
  providers: [IssueService , addIssueGuard , IssueDetailsGuard],
  bootstrap: [AppComponent]
})
export class AppModule { }
