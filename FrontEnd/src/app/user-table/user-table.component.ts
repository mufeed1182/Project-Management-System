import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { SignupService } from '../signup.service';

@Component({
  selector: 'app-user-table',
  templateUrl: './user-table.component.html',
  styleUrls: ['./user-table.component.css']
})
export class UserTableComponent implements OnInit {
  users: User[] = [];
  constructor(private ss:SignupService) { }

  ngOnInit(): void {
    this.fetchUsers();
  }

  fetchUsers(): void {
    this.ss.getUsersByRole('user').subscribe(
      users => {
        // Modify the IDs to start from 1 and increment sequentially
        this.users = users.map((user, index) => ({
          ...user,
          id: index + 1
        }));
      },
    );
  }

}
