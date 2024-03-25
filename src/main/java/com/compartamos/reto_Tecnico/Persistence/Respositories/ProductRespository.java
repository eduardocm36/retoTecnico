package com.compartamos.reto_Tecnico.Persistence.Respositories;

import com.compartamos.reto_Tecnico.DTO.Entities.Product;
import com.compartamos.reto_Tecnico.DTO.Models.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRespository {

    List<Producto> getAll();

    Optional<List<Producto>> getByCategory(int idCategory);

    Optional<Producto> getProduct(int idProduct);

    Product saveProduct(Product product);

    void deleteProduct(int idProducto);
}
