package com.z4greed.core.models.mapper;

import com.z4greed.core.models.dto.CategoryProductDto;
import com.z4greed.core.models.entity.CategoryProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

// ((componentModel = "spring") -> Especifica el modelo de componentes que se utilizará para la generación del mapeador. En este caso, se está utilizando el modelo de componentes de Spring. Esto
// significa que MapStruct generará el mapeador como un componente de Spring, lo que permite que Spring lo administre y lo inyecte automáticamente en otras partes de la aplicación que lo necesiten.
@Mapper(componentModel = "spring")
public interface CategoryProductMapper {

    CategoryProductMapper INSTANCE = Mappers.getMapper(CategoryProductMapper.class);

    public CategoryProductDto entityToDto(CategoryProductEntity entity);
    public CategoryProductEntity dtoToEntity(CategoryProductDto dto);
    @Mapping(target = "idCategoryProduct", ignore = true)
    void updateEntityFromDto(CategoryProductDto dto, @MappingTarget CategoryProductEntity entity);
}
