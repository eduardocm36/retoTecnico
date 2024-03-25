package com.compartamos.reto_Tecnico.Persistence.Mappers.Mapper;

import com.compartamos.reto_Tecnico.DTO.Entities.Category;
import com.compartamos.reto_Tecnico.DTO.Models.Categoria;

public interface CategoryMapper {

    Categoria toCategoria(Category category);

    Category toCategory(Categoria categoria);

}
