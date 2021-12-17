package com.ciclo4.catalogo.service;

import com.ciclo4.catalogo.model.Order;
import com.ciclo4.catalogo.repository.OrderRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    public Optional<Order> getOrder(Integer id) {
        return orderRepository.getOrder(id);
    }

    public Order save(Order order) {
        Optional<Order> maxIdOrder = orderRepository.LastOrderId();
        if (order.getId() == null) {
            if (maxIdOrder.isEmpty()) {
                order.setId(1);
            } else {
                order.setId(maxIdOrder.get().getId() + 1);
            }
        }
        Optional<Order> orderSave = orderRepository.getOrder(order.getId());
        if (orderSave.isEmpty()) {
            return orderRepository.save(order);
        } else {
            return order;
        }
    }

    public Order update(Order order) {
        if (order.getId() != null) {
            Optional<Order> orderUpdate = orderRepository.getOrder(order.getId());
            if (!orderUpdate.isEmpty()) {
                if (order.getRegisterDay() != null) {
                    orderUpdate.get().setRegisterDay(order.getRegisterDay());
                }
                if (order.getStatus() != null) {
                    orderUpdate.get().setStatus(order.getStatus());
                }
                if (order.getSalesMan() != null) {
                    orderUpdate.get().setSalesMan(order.getSalesMan());
                }
                if (order.getProducts() != null) {
                    orderUpdate.get().setProducts(order.getProducts());
                }
                if (order.getQuantities() != null) {
                    orderUpdate.get().setQuantities(order.getQuantities());
                }
                orderRepository.update(orderUpdate.get());
                return orderUpdate.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(Integer id) {
        Optional<Order> orderDelete = orderRepository.getOrder(id);
        if (!orderDelete.isEmpty()) {
            orderRepository.delete(orderDelete.get());
            return true;
        }
        return false;
    }

//Reto 2:
    public List<Order> getOrdersBySalesManId(Integer id) {
        return orderRepository.getOrdersBySalesManId(id);
    }

//Reto 3:
    public List<Order> getOrdersByZone(String zone) {
        return orderRepository.getOrdersByZone(zone);
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.getOrdersByStatus(status);
    }

//Reto 4:
    public List<Order> getOrdersBySalesManIdAndStatus(Integer id, String status) {
        return orderRepository.getOrdersBySalesManIdAndStatus(id, status);
    }

    public List<Order> getOrdersBySalesManIdAndRegisterDay(Integer id, String registerDay) {
        return orderRepository.getOrdersBySalesManIdAndRegisterDay(id, registerDay);
    }
}
