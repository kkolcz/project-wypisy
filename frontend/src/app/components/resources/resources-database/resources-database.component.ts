import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { IResource, IResourceRes } from 'src/app/models/resource.model';
import { ResourcesService } from 'src/app/services/resources.service';

@Component({
  selector: 'app-resources-database',
  templateUrl: './resources-database.component.html',
  styleUrls: ['./resources-database.component.scss'],
})
export class ResourcesDatabaseComponent implements OnInit {
  resourcesList: IResource[] = [];

  constructor(
    private resourcesService: ResourcesService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.resourcesService.fetchResource().subscribe((res) => {
      this.resourcesList = res.data['Materials'];
    });
    console.log(this.resourcesList);
  }

  onAddNew() {
    this.router.navigate(['/', 'resources', 'add']);
  }
}
