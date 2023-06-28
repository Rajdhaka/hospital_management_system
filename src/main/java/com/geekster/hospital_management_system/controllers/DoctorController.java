package com.geekster.hospital_management_system.controllers;
import com.geekster.hospital_management_system.models.Doctor;
import com.geekster.hospital_management_system.services.DoctorService;
import org.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @PostMapping("")
    public ResponseEntity<String>addDoctor(@RequestBody Doctor doctor){
        JSONObject valid = validDoctor(doctor);
        if(!valid.isEmpty()){
            return  new ResponseEntity<String>(valid.toString(), HttpStatus.BAD_REQUEST);
        }
        doctorService.addDoctor(doctor);
        return new ResponseEntity<String>("Doctor is created successfully",HttpStatus.OK);
    }

    public  JSONObject validDoctor(Doctor doctor) {
        JSONObject object = new JSONObject();
        String city = doctor.getDocCity();
        if(!city.equalsIgnoreCase("Delhi") && !city.equalsIgnoreCase("Noida") && !city.equalsIgnoreCase("Faridabad")){
            object.put(city,"Doctor should live in ncr only");
        }
        String speciality = doctor.getDocSpeciality();
        if(!speciality.equalsIgnoreCase("Orthopedic") && !speciality.equalsIgnoreCase("Gynecology") && !speciality.equalsIgnoreCase("Dermatology") && !speciality.equalsIgnoreCase("ENT")){
            object.put(speciality,"doctor should be specialised in Orthopedic, Gynecology, Dermatology, ENT only");
        }
        return object;
    }

    @GetMapping("/all")
    public List<Doctor> getAllDoctor(){
        return doctorService.getAllDoctor();
    }

    @DeleteMapping(value = "/docId/{docId}")
    public ResponseEntity<String>deleteDoctor(@PathVariable long docId){
        return doctorService.deleteDoctor(docId);
    }
}
