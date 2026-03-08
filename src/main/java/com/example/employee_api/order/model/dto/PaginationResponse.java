package com.example.employee_api.order.model.dto;

import java.util.List;

public class PaginationResponse {

    private List<OrderSummary> data;
    private int totalPage;
    private long totalElement;
    private int currentPage;

    public PaginationResponse() {
    }

    public List<OrderSummary> getData() {
        return data;
    }

    public void setData(List<OrderSummary> data) {
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