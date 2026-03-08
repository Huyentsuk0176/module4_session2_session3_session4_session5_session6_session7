package com.example.employee_api.order.service;

import com.example.employee_api.order.model.Order;
import com.example.employee_api.order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import com.example.employee_api.order.model.dto.OrderSummary;
import com.example.employee_api.order.model.dto.PaginationResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByStatus(status);
    }

    public List<Order> getOrdersByCustomerName(String name) {
        return orderRepository.findByCustomerNameContaining(name);
    }
    public List<Order> getAllOrdersSorted(String field, String direction){
        Sort sort;
        if(direction.equalsIgnoreCase("desc")){
            sort=Sort.by(field).descending();
        }else{
            sort=Sort.by(field).ascending();
        }
        return orderRepository.findAll(sort);
    }
    public Page<Order> getOrdersPaged(int page, int size) {

        PageRequest pageable =
                PageRequest.of(page, size, Sort.by("createdAt").descending());

        return orderRepository.findAll(pageable);
    }
    public List<Order> getHighValueOrders(){
        return orderRepository.findHighValueOrders();
    }
    public PaginationResponse findAllAndPagination(Pageable pageable) {

        Page<OrderSummary> page = orderRepository.findAllAndPagination(pageable);

        PaginationResponse response = new PaginationResponse();
        response.setData(page.getContent());
        response.setTotalPage(page.getTotalPages());
        response.setTotalElement(page.getTotalElements());
        response.setCurrentPage(page.getNumber());

        return response;
    }
}
