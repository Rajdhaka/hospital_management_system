package com.geekster.hospital_management_system.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "patientId")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long patientId;

    @NotEmpty(message = "Name is required")
    @Size(min = 3, message = "Name should be at least 3 characters")
    private String patientName;

    @NotEmpty(message = "City is required")
    @Size(max = 20, message = "City should be at most 20 characters")
    private String patientCity;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    private String patientEmail;

    @NotEmpty(message = "Phone number is required")
    @Length(min = 10, max = 10, message = "Phone number should have 10 digits")
    private String patientPhoneNumber;

    @NotEmpty(message = "Symptom is required")
    private String patientSymptoms;

}
