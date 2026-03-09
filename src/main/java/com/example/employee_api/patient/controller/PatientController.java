package com.example.employee_api.patient.controller;

import com.example.employee_api.patient.model.entity.Patient;
import com.example.employee_api.patient.service.PatientService;
import org.springframework.web.bind.annotation.*;
import com.example.employee_api.patient.model.dto.PaginationResponse;
@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    // thêm bệnh nhân
    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.addPatient(patient);
    }

    // xóa bệnh nhân
    @DeleteMapping("/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "Patient deleted successfully";
    }
    @GetMapping("/search")
    public PaginationResponse searchPatients(
            @RequestParam String patientName,
            @RequestParam int page,
            @RequestParam int size) {

        return patientService.searchPatients(patientName, page, size);
    }
}