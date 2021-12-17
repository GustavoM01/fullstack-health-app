import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Symptom } from 'src/app/interfaces/symptom';

@Component({
  selector: 'app-symptom-form',
  templateUrl: './symptom-form.component.html',
  styleUrls: ['./symptom-form.component.css']
})
export class SymptomFormComponent implements OnInit {

  @Input() isEdit = false;
  @Output() newSymptom = new EventEmitter<Symptom>();

  model : Symptom = {} as Symptom;
  @Input() editModel? : Symptom;

  submitted = false;

  nameList = ['NAUSEA', 'STOMACH_PAIN', 'GAS_CRAMPS_OR_BLOATING',
    'VOMITING', 'HEARTBURN', 'DIARRHEA', 'HEADACHE',
    'IRRITABILITY_OR_NERVOUSNESS']
  intensityList = ['DISCOMFORT', 'LOW', 'MILD', 'STRONG', 'SEVERE'];

  constructor() { }

  ngOnInit(): void {
    if(this.editModel) {
      this.model = this.editModel;
    }
  }

  onSubmit() {
  if(!this.model.timeOfSymptom){
      this.model.timeOfSymptom = new Date();
  }
  this.newSymptom.emit(this.model);
  }

}
