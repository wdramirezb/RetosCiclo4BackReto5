package com.ciclo4.catalogo.repository.crud;

import com.ciclo4.catalogo.model.Order;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author Flia Ramirez Palacio
 */
public interface OrderCrudRepository extends MongoRepository<Order, Integer> {

//Contador:
    /**
     * Búsqueda de último número de orden para usar en contador
     */
    Optional<Order> findTopByOrderByIdDesc();

//Reto 2:
    /**
     * Consultar información del vendedor por número de id.
     */
    List<Order> findBySalesManId(Integer id);

//Reto 3:
    /**
     * Consultar las órdenes que se han creado para una zona en particular.
     *
     * Otra forma de consultar:
     *
     * @Query("{'salesMan.Zone' = ?0}") List<Order> findByZone(final String
     * zone);
     */
    List<Order> findBySalesManZone(String zone);

    /**
     * Consultar las órdenes que se han creado por estado.
     *
     * Otra forma de consultar:
     *
     * @Query("{'status' = ?0}") List<Order> findByStatus(final String status);
     */
    List<Order> findByStatus(String status);

//Reto 4:
    /**
     * Consultar las órdenes que se han creado para un vendedor y estado
     */
    List<Order> findBySalesManIdAndStatus(Integer id, String status);

    /**
     * Consultar las órdenes que se han creado para un vendedor y fecha
     */
    List<Order> findBySalesManIdAndRegisterDay(Integer id, Date registerDay);

}
