package com.compartamos.reto_Tecnico.Persistence;

import com.compartamos.reto_Tecnico.DTO.Entities.Product;
import com.compartamos.reto_Tecnico.DTO.Models.Producto;
import com.compartamos.reto_Tecnico.Persistence.CRUD.ProductCrudRepository;
import com.compartamos.reto_Tecnico.Persistence.Mappers.Mapper.ProductMapper;
import com.compartamos.reto_Tecnico.Persistence.Respositories.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class ProductRepositoryImpl implements ProductRespository {

    @Autowired
    private ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper productMapper;


    @Override
    public List<Producto> getAll() {
        List<Product> products = (List<Product>) productCrudRepository.findAll();
        List<Producto> productos = products.stream()
                .map(product -> productMapper.toProducto(product)).collect(Collectors.toList());
        return productos;
    }

    @Override
    public Optional<List<Producto>> getByCategory(int idCategory) {
        Optional<List<Product>> products = productCrudRepository.findByIdCategory(idCategory);
        Optional<List<Producto>> productos = products
                .map(products1 -> products1.stream()
                        .map(product -> productMapper.toProducto(product)).collect(Collectors.toList()));
        return productos;
    }

    @Override
    public Optional<Producto> getProduct(int idProduct) {
        Optional<Product> product = productCrudRepository.findById(Long.valueOf(idProduct));
        Optional<Producto> producto = product.map(prod -> productMapper.toProducto(prod));
        return producto;
    }

    @Override
    public Product saveProduct(Product product) {
        return productCrudRepository.save(product);
    }

    @Override
    public void deleteProduct(int idProducto) {
        productCrudRepository.deleteById(Long.valueOf(idProducto));
    }
}
