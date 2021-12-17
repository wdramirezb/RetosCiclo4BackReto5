package com.ciclo4.catalogo.repository.crud;

import com.ciclo4.catalogo.model.Fragance;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface FraganceCrudRepository extends MongoRepository<Fragance, String> {

//Reto 5: 
    List<Fragance> findByPrice(Double price);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Fragance> findByDescriptionLike(String description);
}
