package com.ciclo4.catalogo.repository;

import com.ciclo4.catalogo.model.Order;
import com.ciclo4.catalogo.repository.crud.OrderCrudRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    @Autowired
    private OrderCrudRepository orderCrudRepository;

    public List<Order> getAll() {
        return (List<Order>) orderCrudRepository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return orderCrudRepository.findById(id);
    }

    public Order save(Order order) {
        return orderCrudRepository.save(order);
    }

    public void update(Order order) {
        orderCrudRepository.save(order);
    }

    public void delete(Order order) {
        orderCrudRepository.delete(order);
    }

//Contador:
    public Optional<Order> LastOrderId() {
        return orderCrudRepository.findTopByOrderByIdDesc();
    }

//Reto 2:
    public List<Order> getOrdersBySalesManId(Integer id) {
        return orderCrudRepository.findBySalesManId(id);
    }

//Reto 3:
    public List<Order> getOrdersByZone(String zone) {
        return orderCrudRepository.findBySalesManZone(zone);
    }
    
    public List<Order> getOrdersByStatus(String status) {
        return orderCrudRepository.findByStatus(status);
    }

//Reto 4:
    public List<Order> getOrdersBySalesManIdAndStatus(Integer id, String status) {
        return orderCrudRepository.findBySalesManIdAndStatus(id, status);
    }

    public List<Order> getOrdersBySalesManIdAndRegisterDay(Integer id, String registerDay) {
        try {
            return orderCrudRepository.findBySalesManIdAndRegisterDay(id, new SimpleDateFormat("yyyy-MM-dd").parse(registerDay));
        } catch (ParseException e) {
            return null;
        }
    }

}
