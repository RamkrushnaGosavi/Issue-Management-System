import { Component, OnInit, ViewChild } from "@angular/core";
import { NgForm } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { Issue } from "../issues/issue";
import { IssueService } from "../issue.service";




@Component({
    selector: 'edit-editIssue',
    templateUrl: './editIssue.component.html',
    styleUrls: ['./editIssue.component.css']
})
export class EditIssueComponent implements OnInit {

    description: string = "";
    status: string = "";
    severity: string = "";
    id: string = "";
    issue: any = null;

    statuss: String[] = ["Open", "Closed", "In Progress"];

    @ViewChild('formRef', { static: false }) editIssueForm !: NgForm;

    constructor(private issueService: IssueService, private router: Router, private activeRouter: ActivatedRoute) { };

    ngOnInit(): void {
        this.editIssue();
    }

    editIssue() {
        this.id = this.activeRouter.snapshot.params['id'];
        this.issueService.getIssueById(this.id).subscribe((data: any) => { this.issue = data });
    }


    updateIssue() {
        this.issueService.updateIssue(this.id, this.issue).subscribe(
            {
                error: error => console.log(error)         
            });

            this.gotoIssueRoute();
    }

    gotoIssueRoute() {
        this.router.navigate(['./issue'])
    }

}