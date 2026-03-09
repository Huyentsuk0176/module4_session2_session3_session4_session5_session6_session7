package com.example.employee_api.patient.model.dto;

import com.example.employee_api.patient.model.entity.Patient;
import java.util.List;

public class PaginationResponse {

    private List<Patient> data;
    private int totalPage;
    private long totalElement;
    private int currentPage;

    public PaginationResponse() {
    }

    public List<Patient> getData() {
        return data;
    }

    public void setData(List<Patient> data) {
        this.data = data;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalElement() {
        return totalElement;
    }

    public void setTotalElement(long totalElement) {
        this.totalElement = totalElement;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}