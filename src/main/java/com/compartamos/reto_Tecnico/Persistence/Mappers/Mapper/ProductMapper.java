package com.compartamos.reto_Tecnico.Persistence.Mappers.Mapper;

import com.compartamos.reto_Tecnico.DTO.Entities.Product;
import com.compartamos.reto_Tecnico.DTO.Models.Producto;

public interface ProductMapper {

    Producto toProducto(Product product);

    Product toProduct(Producto producto);

}
