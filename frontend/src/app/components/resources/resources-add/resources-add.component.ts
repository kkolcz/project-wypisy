import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Resource } from 'src/app/models/resource.model';
import { ResourcesService } from 'src/app/services/resources.service';

@Component({
  selector: 'app-resources-add',
  templateUrl: './resources-add.component.html',
  styleUrls: ['./resources-add.component.scss'],
})
export class ResourcesAddComponent implements OnInit {
  resourceForm: FormGroup;

  constructor(
    private resourcesService: ResourcesService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.resourceForm = new FormGroup({
      resourceName: new FormControl(null, Validators.required),
    });
  }

  onAddResource() {
    const newResource = new Resource(
      Math.random() * 1000,
      this.resourceForm.value.resourceName
    );

    if (this.resourceForm.valid) {
      this.resourcesService.addResource(newResource);
      this.router.navigate(['/', 'resources', 'database']);
    }

    // console.log(this.resourceForm.value.resourceName);
  }
}
