
import { Component, OnInit, ViewChild} from "@angular/core";
import { NgForm } from "@angular/forms";
import { Router } from "@angular/router";
import { Issue } from "../issues/issue";
import { IssueService } from "../issue.service";


@Component({
    selector: 'app-addIssue',
    templateUrl: './addIssue.component.html',
    styleUrls: ['./addIssue.component.css']
  })

  export class addIssueComponent implements OnInit 
  {
    description: string = "";
    redioSelected: string ="";
    severity: string = "";

    status:String[] =  ["Open" , "Closed" , "In Progress" ];

    issue: Issue = new Issue();

    constructor(private _issueService: IssueService , private router:Router){}
    
    
    ngOnInit(): void {
    
    
  };

    @ViewChild('formRef') addIssueForm !: NgForm;

    
add()
{
  
  this.issue.description = this.description;
  this.issue.severity = this.severity;
  this.issue.status = this.redioSelected;

  console.log(this.issue);

  this._issueService.postIssue(this.issue).subscribe(
    {
      error : error => console.log(error)          //error
    }
  );

  this.addIssueForm.resetForm();

  this.gotoIssueRoute();
  
}


gotoIssueRoute()
{
    this.router.navigate(['./issue'])
}
    

    
}