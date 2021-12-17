import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IUser } from 'src/app/interfaces/user';
import { Symptom } from 'src/app/interfaces/symptom';
import { UserService } from 'src/app/services/user.service';
import { SymptomService } from 'src/app/services/symptom.service';

@Component({
  selector: 'app-user-symptom',
  templateUrl: './user-symptom.component.html',
  styleUrls: ['./user-symptom.component.css']
})
export class UserSymptomComponent implements OnInit {

  user : IUser = {} as IUser;
  symptoms! : Symptom[];

  // For adding new meal
  addSymptomDisplayForm : boolean = false;
  newSymptom! : Symptom;
  // For meal form: new meal or edit meal
  editSymptomDisplayForm : boolean = false;
  isEdit = false;
  symptomIdToEdit? : number;

  constructor(private route : ActivatedRoute,
              private userService : UserService,
              private symptomService : SymptomService) { }

  ngOnInit(): void {
    const routeParams = this.route.snapshot.paramMap;
    const idFromRoute = Number(routeParams.get('id'));
    this.getUser(idFromRoute);
  }

  async getUser(id: number) : Promise<void> {
    const userPromise = await this.userService.getUser(id).toPromise();
    this.user = userPromise;
    this.symptomService.getSymptoms().subscribe(allSymptoms => this.symptoms = allSymptoms.filter(symptom => symptom.userId === id));
      
  }

  async addSymptom(symptom : Symptom): Promise<void> {
    symptom.userId = this.user.id;
    symptom.description = '';
    this.newSymptom = await this.symptomService.saveSymptom(symptom).toPromise();
    this.symptoms.push(this.newSymptom);
  }

  editSymptom(editSymptom : Symptom) {
    this.symptomService.updateSymptom(editSymptom).subscribe();
  }

  displayForm(value : string, symptom? : Symptom): void {
    if (value === 'add')
      this.addSymptomDisplayForm = !this.addSymptomDisplayForm;
    else if (value === 'edit')
    {
      this.editSymptomDisplayForm = !this.editSymptomDisplayForm;
      this.symptomIdToEdit = symptom?.id;
      this.isEdit = true;
    }  
  }

  deleteSymptom(symptom : Symptom) : void {
    this.symptomService.deleteSymptom(symptom.id).subscribe();
    this.symptoms.splice(this.symptoms.indexOf(symptom), 1);
  }

}
