
import { Injectable } from '@angular/core';
import { CanDeactivate } from '@angular/router';
import { addIssueComponent } from './addIssue.component';

@Injectable()
export class addIssueGuard implements CanDeactivate<addIssueComponent> {

    canDeactivate(component: addIssueComponent): boolean {
       
        if (component.addIssueForm.dirty && !component.addIssueForm.submitted) {
            return confirm('Do you want to leave this page?');
        }
       
        return true;
     
        
    }

}


