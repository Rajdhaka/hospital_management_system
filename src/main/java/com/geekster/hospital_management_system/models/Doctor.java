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

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, scope = Doctor.class,property = "doctorId")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long docId;

    @NotEmpty(message = "Name is required")
    @Size(min = 3, message = "Name should be at least 3 characters")
    private String docName;

    @NotEmpty(message = "City is required")
    @Size(max = 20, message = "City should be at most 20 characters")
    private String docCity;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    private String docEmail;

    @NotEmpty(message = "Phone number is required")
    @Length(min = 10, max = 10, message = "Phone number should have 10 digits")
    private String docPhoneNumber;

    @NotEmpty(message = "Speciality is required")
    private String docSpeciality;

}

