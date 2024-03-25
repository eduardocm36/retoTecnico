package com.compartamos.reto_Tecnico.Controllers;

import com.compartamos.reto_Tecnico.DTO.Entities.Product;
import com.compartamos.reto_Tecnico.DTO.Models.Producto;
import com.compartamos.reto_Tecnico.Exceptions.AppException;
import com.compartamos.reto_Tecnico.Exceptions.ExceptionDetails;
import com.compartamos.reto_Tecnico.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@RestController
@RequestMapping("/product")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping("/")
    public List<Producto> getAll(){
        return productoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> getById(@PathVariable("id") int idProducto) throws AppException{
        return productoService.getById(idProducto).map(producto -> new ResponseEntity(producto, HttpStatus.OK))
                .orElseThrow(() -> new AppException("ID inexistente",
                        new ExceptionDetails("No se econtraron coincidencias", HttpStatus.NOT_FOUND.value())));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<Producto>> getByCategory(@PathVariable("id") int idCategory) throws AppException{
        return productoService.getByCategory(idCategory).filter(productos -> !productos.isEmpty())
                .map(productos -> new ResponseEntity<>(productos, HttpStatus.OK))
                .orElseThrow(() -> new AppException("Id Inexistente",
                        new ExceptionDetails("No se encontraron coincidencias", HttpStatus.NOT_FOUND.value())));
    }

    @PostMapping("/")
    public ResponseEntity<Product> saveProducto(@RequestBody Product product) throws AppException{
        Optional<Product> product1 = productoService.saveProducto(product);
        return product1.map(product2 -> new ResponseEntity<>(product2, HttpStatus.CREATED))
                .orElseThrow(() -> new AppException("Error al crear elemento",
                        new ExceptionDetails("Error al crear el producto",
                                HttpStatus.BAD_REQUEST.value())));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable int idProducto) throws AppException{
        Optional<Producto> producto = productoService.getById(idProducto);
        if(producto.isPresent()){
            productoService.deleteProduct(idProducto);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
