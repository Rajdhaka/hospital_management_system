package com.geekster.hospital_management_system.services;

import com.geekster.hospital_management_system.models.Doctor;
import com.geekster.hospital_management_system.models.Patient;
import com.geekster.hospital_management_system.repositories.IDoctorRepo;
import com.geekster.hospital_management_system.repositories.IPatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    IPatientRepo patientRepo;
    @Autowired
    IDoctorRepo doctorRepo;

    public void addPatient(Patient patient) {
        patientRepo.save(patient);
    }

    public List<Patient> getAllPatient() {
        return patientRepo.findAll();
    }

    public ResponseEntity<String> deletePatient(long patientId) {
        if (patientRepo.findById(patientId).isPresent()) {
            patientRepo.deleteById(patientId);
            return new ResponseEntity<String>("Patient deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Not valid data", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Doctor>> suggestDoctor(long patientId) {
        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid patient ID"));

        String city = patient.getPatientCity();
        String symptom = patient.getPatientSymptoms();

        List<Doctor> doctors = doctorRepo.findByDocCityAndDocSpeciality(city, getSpeciality(symptom));
        String status = "";
        if (doctors.isEmpty()) {
            if(!city.equalsIgnoreCase("Delhi") && !city.equalsIgnoreCase("Noida") && !city.equalsIgnoreCase("Faridabad")){
                status = "We are still waiting to expand to your location";
            }
            else{
                status = "There isn’t any doctor present at your location for your symptom";
            }
            throw new IllegalStateException(status);
        }

        return ResponseEntity.status(HttpStatus.OK)
                .body(doctors);
    }

    public String getSpeciality(String symptom) {
        switch (symptom) {
            case "Arthritis":
            case "Back Pain":
            case "Tissue injuries":
                return "Orthopedic";
            case "Dysmenorrhea":
                return "Gynecology";
            case "Skin infection":
            case "Skin burn":
                return "Dermatology";
            case "Ear pain":
                return "ENT specialist";
            default:
                throw new IllegalArgumentException("There isn’t any doctor present at your location for your symptom");
        }
    }
}

