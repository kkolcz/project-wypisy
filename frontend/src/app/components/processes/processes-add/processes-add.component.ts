import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Process } from 'src/app/models/process.model';

@Component({
  selector: 'app-processes-add',
  templateUrl: './processes-add.component.html',
  styleUrls: ['./processes-add.component.scss'],
})
export class ProcessesAddComponent implements OnInit {
  processForm: FormGroup;

  constructor() {}

  ngOnInit(): void {
    this.processForm = new FormGroup({
      processName: new FormControl(null, Validators.required),
      processCategory: new FormControl(null, Validators.required),
      processLocalization: new FormControl(null, Validators.required),
      processTime: new FormControl(null, Validators.required),
    });
  }

  onAddProcess() {
    if (this.processForm.valid) {
      const newProcess = new Process(
        this.processForm.value.processName,
        this.processForm.value.processCategory,
        this.processForm.value.processLocalization,
        this.processForm.value.processTime
      );

      console.log(newProcess);
    }
  }
}
