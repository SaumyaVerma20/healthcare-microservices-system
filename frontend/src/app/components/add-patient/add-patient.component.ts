import { Component, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router, RouterLink } from '@angular/router';
import { PatientService } from '../../services/patient/patient/patient.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-patient',
  standalone: true,
  imports: [ReactiveFormsModule, CommonModule, RouterLink],
  templateUrl: './add-patient.component.html',
  styleUrls: ['./add-patient.component.css']
})
export class AddPatientComponent {
  private fb = inject(FormBuilder);
  private patientService = inject(PatientService);
  private router = inject(Router);

  patientForm = this.fb.group({
    name: ['', [Validators.required, Validators.maxLength(100)]],
    email: ['', [Validators.required, Validators.email]],
    address: ['', Validators.required],
    dateOfBirth: ['', Validators.required],
    registeredDate: [new Date().toISOString().split('T')[0], Validators.required]
  });

  isSubmitting = false;
  error = '';

  onSubmit() {
    if (this.patientForm.valid) {
      this.isSubmitting = true;
      this.error = '';

      const formData = {
        name: this.patientForm.value.name as string,
        email: this.patientForm.value.email as string,
        address: this.patientForm.value.address as string,
        dateOfBirth: this.patientForm.value.dateOfBirth as string,
        registeredDate: this.patientForm.value.registeredDate as string
      };

      this.patientService.createPatient(formData).subscribe({
        next: () => {
          this.isSubmitting = false;
          this.router.navigate(['/dashboard']);
        },
        error: (err) => {
          console.error('Error creating patient', err);
          this.error = 'Failed to register patient. Please check your data and try again.';
          this.isSubmitting = false;
        }
      });
    }
  }
}
