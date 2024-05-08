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
 
  }

}
