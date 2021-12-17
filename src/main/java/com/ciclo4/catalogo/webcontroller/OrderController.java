package com.ciclo4.catalogo.webcontroller;

import com.ciclo4.catalogo.model.Order;
import com.ciclo4.catalogo.service.OrderService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que define la API para captura, consulta, actualización, eliminación y
 * validación de datos. La define como controlador REST y establece la URL base
 * como '/api/order'.
 *
 * @author William David Ramírez Blauvelt
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {

    /**
     * Indica que los servicios se deben conectan automaticamente sin necesidad
     * de definierlos. "Inyecta" unas dependencias con otras dentro de Spring.
     */
    @Autowired
    private OrderService orderService;

    /**
     * Establece URL para consultar (GET) todos los datos de todos las órdenes
     * creadas.
     *
     * @return: id, fecha de registro, estado, vendedor, productos y cantidades.
     */
    @GetMapping("/all")
    public List<Order> getAll() {
        return orderService.getAll();
    }

    /**
     * Establece URL para consultar (GET) todos los datos de una orden en
     * particular.
     *
     * @param: id de orden.
     * @return: id, fecha de registro, estado, vendedor, productos y cantidades
     * de la orden consultada.
     */
    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") Integer id) {
        return orderService.getOrder(id);
    }

    /**
     * Establece URL para guardar (POST) nuevas órdenes.
     *
     * @param: fecha de registro, estado, vendedor, productos y cantidades.
     * @return: id, fecha de registro, estado, vendedor, productos y cantidades
     * de la orden creada.
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }

    /**
     * Establece URL para actualizar (PUT) información de una orden.
     *
     * @param: id, fecha de registro, estado, vendedor, productos y cantidades
     * @return: id, fecha de registro, estado, vendedor, productos y cantidades
     * de la orden actualizada.
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order) {
        return orderService.update(order);
    }

    /**
     * Establece URL para eliminar (DELETE) todos los datos de una orden en
     * particular.
     *
     * @param: id de orden.
     * @return: @return: true o false.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderService.delete(id);
    }

//Reto 2:
    /**
     * Establece URL para consultar (GET) todas las órdenes creadas por un
     * vendedr en particular.
     *
     * @param: id de vendedor.
     * @return: detalle de las órdenes.
     */
    @GetMapping("/salesman/{id}")
    public List<Order> getOrdersBySalesManId(@PathVariable("id") Integer id) {
        return orderService.getOrdersBySalesManId(id);
    }

//Reto 3:
    /**
     * Establece URL para consultar (GET) todas las órdenes creadas en una zona
     * en particular.
     *
     * @param: zona.
     * @return: detalle de las órdenes.
     */
    @GetMapping("/zona/{zone}")
    public List<Order> getOrdersByZone(@PathVariable("zone") String zone) {
        return orderService.getOrdersByZone(zone);
    }

    /**
     * Establece URL para consultar (GET) todas las órdenes con un estado en
     * particular.
     *
     * @param: estado.
     * @return: detalle de las órdenes.
     */
    @GetMapping("/state/{status}")
    public List<Order> getOrdersByStatus(@PathVariable("status") String status) {
        return orderService.getOrdersByStatus(status);
    }

//Reto 4:
    /**
     * Establece URL para consultar (GET) todas las órdenes con un estado y
     * vendedor en particular.
     *
     * @param: estado e id de vendedor.
     * @return: detalle de las órdenes.
     */
    @GetMapping("/state/{status}/{id}")
    public List<Order> getOrdersBySalesManIdAndStatus(@PathVariable("id") Integer id, @PathVariable("status") String status) {
        return orderService.getOrdersBySalesManIdAndStatus(id, status);
    }

    /**
     * Establece URL para consultar (GET) todas las órdenes con una fecha y
     * vendedor en particular.
     *
     * @param: estado e id de vendedor.
     * @return: detalle de las órdenes.
     */
    @GetMapping("/date/{registerDay}/{id}")
    public List<Order> getOrdersBySalesManIdAndRegisterDay(@PathVariable("id") Integer id, @PathVariable("registerDay") String registerDay) {
        return orderService.getOrdersBySalesManIdAndRegisterDay(id, registerDay);
    }
}
