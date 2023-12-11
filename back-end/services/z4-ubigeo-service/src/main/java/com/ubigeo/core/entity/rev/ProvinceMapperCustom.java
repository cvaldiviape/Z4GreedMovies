//package com.ubigeo.core.entity.mapper;
//
//import com.shared.dto.ProvinceDto;
//import com.ubigeo.core.entity.ProvinceEntity;
//import org.mapstruct.*;
//import java.util.Set;
//
//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {DepartmentMapperCustom.class})
//public interface ProvinceMapperCustom {
//
//    // Don't forget to add the matching inverse mapping from DTO to Entity, this is basically just a copy with switch input parameter and return types
//    @Named("ProvinceMapperCustom.IngredientSetIgnoreRecipes")
//    @IterableMapping(qualifiedByName = "ProvinceMapperCustom.IngredientIgnoreRecipes")  // Refer to the mapping for a single object in the collection
//    Set<ProvinceDto> toDTOSetIgnoreRecipes(Set<ProvinceEntity> ingredients);
//
//    // Don't forget to add the matching inverse mapping from DTO to Entity, this is basically just a copy with switch input parameter and return types
//    @Named("ProvinceMapperCustom.IngredientIgnoreRecipes")
//    @Mappings({
//            @Mapping(target = "department", ignore = true), // ignore the recipes property entirely
//    })
//    ProvinceDto toDTOIgnoreRecipes(ProvinceEntity ingredient);
//
//    @Mappings({
//            @Mapping(target = "department", qualifiedByName = "DepartmentMapperCustom.RecipeSetIgnoreIngredientsAndBookChildRecipe")
//    })
//    ProvinceDto toDTO(ProvinceEntity ingredient);
//
//    @Named("ProvinceMapperCustom.IngredientSetIgnoreRecipes222")
//    @IterableMapping(qualifiedByName = "ProvinceMapperCustom.IngredientIgnoreRecipes")  // Refer to the mapping for a single object in the collection
//    Set<ProvinceEntity> toEntitySetIgnoreRecipes(Set<ProvinceDto> ingredientDTOs);
//
//    @Named("ProvinceMapperCustom.IngredientIgnoreRecipes")
//    @Mappings({
//            @Mapping(target = "department", ignore = true),
//    })
//    ProvinceEntity toEntityIgnoreRecipes(ProvinceDto ingredientDTO);
//
//    @Mappings({
//            @Mapping(target = "department", qualifiedByName = "DepartmentMapperCustom.RecipeSetIgnoreIngredientsAndBookChildRecipe333")
//    })
//    ProvinceEntity toEntityIgnoreRecipes22(ProvinceDto ingredientDTO);
//
//}