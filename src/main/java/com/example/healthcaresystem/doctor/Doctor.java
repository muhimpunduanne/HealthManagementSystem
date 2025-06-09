package com.example.healthcaresystem.doctor;

import com.example.healthcaresystem.appointment.Appointment;
import com.example.healthcaresystem.clinic.Clinic;
import com.example.healthcaresystem.medicalrecord.MedicalRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    private String firstName;
    @Column(length = 50, nullable = false)
    private String lastName;
    @Column(length = 100, nullable = false)
    private String specialty;
    @Column ( nullable = false,unique = true )
    private String email;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Clinic clinic;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "doctor")
    private List<MedicalRecord> medicalRecords;

}
