package com.geekster.hospital_management_system.services;

import com.geekster.hospital_management_system.models.Doctor;
import com.geekster.hospital_management_system.repositories.IDoctorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    IDoctorRepo doctorRepo;

    public void addDoctor(Doctor doctor) {
        doctorRepo.save(doctor);
    }

    public List<Doctor> getAllDoctor() {
        return doctorRepo.findAll();
    }


    public ResponseEntity<String> deleteDoctor(long docId) {
        if(doctorRepo.findById(docId).isPresent()){
            doctorRepo.deleteById(docId);
            return new ResponseEntity<String>("Doctor deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<String>("Doctor does not deleted", HttpStatus.BAD_REQUEST);
    }
}
