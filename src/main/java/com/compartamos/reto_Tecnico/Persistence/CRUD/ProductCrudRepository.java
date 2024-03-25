package com.compartamos.reto_Tecnico.Persistence.CRUD;

import com.compartamos.reto_Tecnico.DTO.Entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Long> {

    Optional<List<Product>> findByIdCategory(int idCategoria);

}
