package com.compartamos.reto_Tecnico.Services;

import com.compartamos.reto_Tecnico.DTO.Entities.Product;
import com.compartamos.reto_Tecnico.DTO.Models.Producto;
import com.compartamos.reto_Tecnico.Persistence.Respositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductRespository productRespository;

    public List<Producto> getAll(){
        return productRespository.getAll();
    }

    public Optional<List<Producto>> getByCategory(int idCategory){
        return productRespository.getByCategory(idCategory);
    }

    public Optional<Producto> getById(int idProducto){
        return productRespository.getProduct(idProducto);
    }

    public Optional<Product> saveProducto(Product product){
        Optional<Product> productResponse = Optional.of(productRespository.saveProduct(product));
        return productResponse;
    }

    public void deleteProduct(int idProduct){
        productRespository.deleteProduct(idProduct);
    }

}
