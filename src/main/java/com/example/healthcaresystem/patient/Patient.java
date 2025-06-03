package com.example.healthcaresystem.patient;

import com.example.healthcaresystem.appointment.Appointment;
import com.example.healthcaresystem.clinic.Clinic;
import com.example.healthcaresystem.medicalrecord.MedicalRecord;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column ( length = 50, nullable = false)
    @NotBlank
    private String firstName;
    @NotBlank
    @Column ( length = 50, nullable = false)
    private String lastName;
    @Column(unique = true,nullable = false)
    @Email
    @NotBlank
    private String email;
    @Column ( length = 20, nullable = false)
    @NotBlank
    @Pattern(regexp = "^[0-9]+$", message = "Phone must contain only numbers")
    private String phone;
    @Column (  nullable = false)
    @Past(message = "Date of birth must be in the past")
    @NotNull
    private LocalDate dateOfBirth;
    @ManyToOne
    @JoinColumn(name = "clinic_id")
    private Clinic clinic;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<Appointment> appointments ;
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private List<MedicalRecord > medicalRecords ;

}
