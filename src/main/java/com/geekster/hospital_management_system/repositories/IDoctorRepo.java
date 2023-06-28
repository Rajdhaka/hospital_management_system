package com.geekster.hospital_management_system.repositories;

import com.geekster.hospital_management_system.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDoctorRepo extends JpaRepository<Doctor,Long> {
    List<Doctor> findByDocCityAndDocSpeciality(String city, String speciality);

}
