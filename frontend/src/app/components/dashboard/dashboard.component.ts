import { Component, OnInit, inject } from '@angular/core';
import { PatientService, Patient } from '../../services/patient/patient/patient.service';
import { AuthService } from '../../services/auth/auth/auth.service';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  private patientService = inject(PatientService);
  private authService = inject(AuthService);
  private router = inject(Router);

  patients: Patient[] = [];
  isLoading = true;
  error = '';

  ngOnInit() {
    this.loadPatients();
  }

  loadPatients() {
    this.isLoading = true;
    this.patientService.getPatients().subscribe({
      next: (data) => {
        this.patients = data;
        this.isLoading = false;
      },
      error: (err) => {
        console.error('Error fetching patients', err);
        this.error = 'Failed to load patients. Please try again.';
        this.isLoading = false;
      }
    });
  }

  deletePatient(id: string) {
    if (confirm('Are you sure you want to delete this patient?')) {
      this.patientService.deletePatient(id).subscribe({
        next: () => {
          this.patients = this.patients.filter(p => p.id !== id);
        },
        error: (err) => {
          console.error('Error deleting patient', err);
          alert('Failed to delete patient');
        }
      });
    }
  }

  logout() {
    this.authService.logout();
    this.router.navigate(['/login']);
  }
}
