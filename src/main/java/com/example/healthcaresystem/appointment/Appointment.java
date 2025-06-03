package com.example.healthcaresystem.appointment;

import com.example.healthcaresystem.doctor.Doctor;
import com.example.healthcaresystem.patient.Patient;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn (name = "patient_id,nullebal = false")
   private  Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
    @NotNull
    @Future(message = "Appointment date must be in the future")
    private LocalDateTime appointmentDate;
    @NotNull
    @Enumerated(EnumType.STRING)
    private AppointmentStatus appointmentStatus;
    @Size(max = 500)
    private String notes;
}
