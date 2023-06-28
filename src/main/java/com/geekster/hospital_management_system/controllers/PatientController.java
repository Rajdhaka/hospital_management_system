package com.geekster.hospital_management_system.controllers;

import com.geekster.hospital_management_system.models.Doctor;
import com.geekster.hospital_management_system.models.Patient;
import com.geekster.hospital_management_system.services.PatientService;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("")
    public ResponseEntity<String> addPatient(@Valid @RequestBody Patient patient) {
        patientService.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body("Patient added successfully");
    }
    @GetMapping("/all")
    public List<Patient> getAllPatient(){
        return patientService.getAllPatient();
    }

    @DeleteMapping(value = "/patientId/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable long patientId){
        return patientService.deletePatient(patientId);
    }

    @GetMapping(value = "/patientId/{patientId}")
    public ResponseEntity<List<Doctor>>suggestDoctor(@PathVariable long patientId){
        return patientService.suggestDoctor(patientId);

    }


}
