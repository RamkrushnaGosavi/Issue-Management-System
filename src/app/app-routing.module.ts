import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AboutComponent } from './about/about.component';
import { addIssueComponent } from './addIssue/addIssue.component';
import { addIssueGuard } from './addIssue/addIssue.guard';
import { EditIssueComponent } from './editIssue/editIssue.component';
import { IssueDetailsComponent } from './issueDetails/issueDetails.component';
import { IssueDetailsGuard } from './issueDetails/issueDetails.guard';
import { IssueComponent } from './issues/issue.component';

const routes: Routes = [

  {path: '' , component:AboutComponent},
  {path: 'about' , component: AboutComponent},
  {path: 'issue' , component: IssueComponent },
  {path: 'issue/addIssue', component: addIssueComponent , canDeactivate:[addIssueGuard]},
  {path: 'issue/editIssue/:id' , component: EditIssueComponent},
  {path: 'issue/issueDetails/:id' , component: IssueDetailsComponent , canActivate:[IssueDetailsGuard]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
