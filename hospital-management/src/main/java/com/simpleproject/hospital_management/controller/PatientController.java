package com.simpleproject.hospital_management.controller;

import com.simpleproject.hospital_management.model.Patient;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
@RestController
@RequestMapping("/patient/apis")
public class PatientController {

    HashMap<Integer, Patient> paitentHashMap = new HashMap<>();

    @PostMapping("/save")
    public String savePatient(@RequestBody  Patient patient)
    {
        paitentHashMap.put(patient.getId(), patient);
        System.out.println(paitentHashMap);
        return "patient save successfully";
    }
    @GetMapping("/findAll")
    public HashMap<Integer,Patient> getAllPatient()
    {
        return paitentHashMap;
    }

    @GetMapping("/find/{id}")
    public Patient getPatientById(@PathVariable int id)
    {
        Patient patient = paitentHashMap.get(id);
        return patient;
    }

    @DeleteMapping("/delete/{id}")
    public String deletePatientById(@PathVariable int id)
    {
        paitentHashMap.remove(id);
        return "Patient deleted Successfully";
    }

    @PutMapping("/update/{id}")
    public String updatePatient(@PathVariable int id,@RequestBody Patient patient)
    {
        Patient patient1 = paitentHashMap.get(id);
        if(patient1!=null)
        {
            paitentHashMap.put(id,patient);
            return "Patient updated Successfully";
        }
        else
        {
            return "Patient not foundwith that id" +id;
        }
    }
}
