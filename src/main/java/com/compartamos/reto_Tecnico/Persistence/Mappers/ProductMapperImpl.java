package com.compartamos.reto_Tecnico.Persistence.Mappers;

import com.compartamos.reto_Tecnico.DTO.Entities.Product;
import com.compartamos.reto_Tecnico.DTO.Models.Producto;
import com.compartamos.reto_Tecnico.Persistence.Mappers.Mapper.CategoryMapper;
import com.compartamos.reto_Tecnico.Persistence.Mappers.Mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Producto toProducto(Product product) {
        Producto producto = new Producto();
        producto.setId(product.getId());
        producto.setNombre(product.getName());
        producto.setDescripcion(product.getDescription());
        producto.setPrecio(product.getPrice());
        producto.setCategoria(product.getCategory().equals(null) ? null : categoryMapper.toCategoria(product.getCategory()));
        return producto;
    }

    @Override
    public Product toProduct(Producto producto) {
        return null;
    }
}
