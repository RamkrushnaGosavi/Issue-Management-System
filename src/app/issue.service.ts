import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Issue } from "./issues/issue";


@Injectable()
export class IssueService
{

    path: string = "http://localhost:8080";

    private httpOptions={
        headers:new HttpHeaders({
          'Content-Type':'application/json'
        })
      };

    constructor(private _http: HttpClient){};

    getIssue()
    {
        return this._http.get(this.path+"/getIssue");
    }

    postIssue(issue : Issue)
    {
        return this._http.post(this.path+"/addIssue" , issue , this.httpOptions);
    }

    getIssueById(id: string)
    {
      console.log(this.path+id);
      return this._http.get((`${this.path}/${id}`));
    }

    updateIssue(id:string,issue:Issue){
      return this._http.put(`${this.path+"/updateIssue"}/${id}`,issue);
    }

    deleteIssue(id:string)
    {
        return this._http.delete(`${this.path+"/deleteIssue"}/${id}`);
    }

}