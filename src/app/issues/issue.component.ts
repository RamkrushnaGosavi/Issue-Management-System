import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { IssueService } from "../issue.service";


@Component({
    selector: 'app-issue',
    templateUrl: './issue.component.html',
    styleUrls: ['./issue.component.css']
  })

  export class IssueComponent implements OnInit
  {
    issues:any=[];

    constructor(private issueService: IssueService ,private router: Router){}; //DI

    ngOnInit(): void {

      this.getIssue();
      
    }

    getIssue()
    {
        this.issueService.getIssue().subscribe(
          {
            next : (data : any) => this.issues = data ,
            error : error => console.log(error)
          }
        );
        
    }

    editIssue(id: string) {
      console.log(id);
      this.router.navigate(['issue/editIssue',id]);
    }

    deleteIssue(id: string)
    {
        this.issueService.deleteIssue(id).subscribe(
          {
            error: (error) => console.log(error)
          }
        );

        location.reload();
        
    }

  }