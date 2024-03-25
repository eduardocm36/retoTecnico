package com.compartamos.reto_Tecnico.Persistence.Mappers;

import com.compartamos.reto_Tecnico.DTO.Entities.Category;
import com.compartamos.reto_Tecnico.DTO.Models.Categoria;
import com.compartamos.reto_Tecnico.Persistence.Mappers.Mapper.CategoryMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public Categoria toCategoria(Category category) {
        Categoria categoria = new Categoria();
        categoria.setId(category.getId());
        categoria.setDescripcion(category.getDescription());
        return categoria;
    }

    @Override
    public Category toCategory(Categoria categoria) {
        Category category = new Category();
        category.setId(categoria.getId());
        category.setDescription(categoria.getDescripcion());
        return null;
    }
}
