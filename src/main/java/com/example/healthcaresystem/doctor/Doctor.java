package com.example.healthcaresystem.doctor;

import com.example.healthcaresystem.appointment.Appointment;
import com.example.healthcaresystem.clinic.Clinic;
import jakarta.persistence.*;

import java.util.List;

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
    @JoinColumn (name = "clinic_id", nullable = false )
    private Clinic clinic;
    @OneToMany (mappedBy = "doctor",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Appointment> appointments;
}
