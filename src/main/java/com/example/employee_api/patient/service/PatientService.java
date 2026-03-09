package com.example.employee_api.patient.service;

import com.example.employee_api.patient.model.entity.Patient;
import com.example.employee_api.patient.repository.PatientRepository;
import org.springframework.stereotype.Service;
import com.example.employee_api.patient.model.dto.PaginationResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
    public PaginationResponse searchPatients(String patientName, int page, int size) {

        Pageable pageable =
                PageRequest.of(page, size, Sort.by("fullName").ascending());

        Page<Patient> patientPage =
                patientRepository.findByFullNameContaining(patientName, pageable);

        PaginationResponse response = new PaginationResponse();

        response.setData(patientPage.getContent());
        response.setTotalPage(patientPage.getTotalPages());
        response.setTotalElement(patientPage.getTotalElements());
        response.setCurrentPage(patientPage.getNumber());

        return response;
    }
}