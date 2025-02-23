package com.simpleproject.hospital_management.controller;

import com.simpleproject.hospital_management.model.Doctor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
@RequestMapping("/doctor/apis")
public class DoctorController {

    HashMap<Integer, Doctor> doctorDbHashMap = new HashMap<>();

    @PostMapping("/save")
    public String saveDoctor(@RequestBody Doctor doctor)
    {
        doctorDbHashMap.put(doctor.getId(),doctor);
        System.out.println(doctorDbHashMap);
      return "Doctor saved successfully";
    }

    @GetMapping("/findAll")
    public HashMap<Integer, Doctor> getAllDoctor()
    {
        return doctorDbHashMap;
    }

    @GetMapping("/find/{id}")
    public Doctor getDoctorById(@PathVariable int id)
    {
        Doctor doctor = doctorDbHashMap.get(id);
        return doctor;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDoctorById(@PathVariable int id)
    {
        doctorDbHashMap.remove(id);
        return "Doctor deleted Successfully";
    }
    @PutMapping("/update/{id}")
    public String updateDoctor(@PathVariable int id,@RequestBody Doctor doctor)
    {
        Doctor doctor1 = doctorDbHashMap.get(id);
        if(doctor1!=null)
        {
            doctorDbHashMap.put(id,doctor);
            return "Doctor updated successfully";
        }
        else{
            return "Doctor not found with that id :" +id;
        }
    }
}
