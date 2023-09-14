import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { Issue } from "../issues/issue";
import { IssueService } from "../issue.service";



@Component({

    selector: 'issue-issueDetails',
    templateUrl: './issueDetails.component.html',
    styleUrls: ['./issueDetails.component.css']
})
export class IssueDetailsComponent implements OnInit
{

    issue: any = null;
    id : string = "";

    constructor(private issuService: IssueService , private router: Router , private activeRoute: ActivatedRoute){}
    
    
    ngOnInit(): void {
       
        this.issue = new Issue();

        this.id = this.activeRoute.snapshot.params['id'];

        this.issuService.getIssueById(this.id).subscribe(
           { next: (data: any) => this.issue = data,
            error: (error) => console.log(error)}
        );

    };



    goBack()
    {
        this.router.navigate(['issue']);
    }

}