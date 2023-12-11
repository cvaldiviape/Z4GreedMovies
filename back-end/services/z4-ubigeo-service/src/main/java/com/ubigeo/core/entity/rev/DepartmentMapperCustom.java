//package com.ubigeo.core.entity.mapper;
//
//import com.shared.dto.DepartmentDto;
//import com.ubigeo.core.entity.DepartmentEntity;
//import org.mapstruct.*;
//import java.util.Set;
//
//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {ProvinceMapperCustom.class})
//public interface DepartmentMapperCustom {
//
//    @Named("DepartmentMapperCustom.RecipeSetIgnoreBookAndIngredientChildRecipes")
//    @IterableMapping(qualifiedByName = "DepartmentMapperCustom.RecipeIgnoreBookAndIngredientChildRecipes")
//    Set<DepartmentDto> toDTOSetIgnoreBookAndIngredientChildRecipes(Set<DepartmentEntity> recipes);
//
//    @Named("DepartmentMapperCustom.RecipeSetIgnoreIngredientsAndBookChildRecipe")
//    @IterableMapping(qualifiedByName = "DepartmentMapperCustom.RecipeIgnoreIngredientsAndBookChildRecipe")
//    Set<DepartmentDto> toDTOSetIgnoreIngredientsAndBookChildRecipe(Set<DepartmentEntity> recipes);
//
//    // In this mapping we will ignore the book property and the recipe property of the Ingredients to break the mapping cyclic references when we are mapping a book object
//    // Don't forget to add the matching inverse mapping from DTO to Entity, this is basically just a copy with switch input parameter and return types
//    @Named("DepartmentMapperCustom.RecipeIgnoreBookAndIngredientChildRecipes")
//    @Mappings({
//            @Mapping(target = "listProvinces", qualifiedByName = "ProvinceMapperCustom.IngredientSetIgnoreRecipes"), // ingredients is a collection of complex objects, so we can't directly ignore its child properties as in the end, a Mapper needs to be defined to Map a single POJO into another
//    })
//    DepartmentDto toDTOIgnoreBookAndIngredientChildRecipes(DepartmentEntity recipe);
//
//    @Named("DepartmentMapperCustom.RecipeIgnoreIngredientsAndBookChildRecipe")
//    @Mappings({
//            @Mapping(target = "listProvinces", ignore = true),
//    })
//    DepartmentDto toDTOIgnoreIngredientsAndBookChildRecipe(DepartmentEntity recipe);
//
//    // Don't forget to add the matching inverse mapping from DTO to Entity, this is basically just a copy with switch input parameter and return types
//    @Mappings({
//            @Mapping(target = "listProvinces", qualifiedByName = "ProvinceMapperCustom.IngredientSetIgnoreRecipes"), // ingredients is a collection of complex objects, so we can't directly ignore its child properties as in the end, a Mapper needs to be defined to Map a single POJO into another
//    })
//    DepartmentDto toDTO(DepartmentEntity recipe);
//
//    @Named("DepartmentMapperCustom.RecipeSetIgnoreBookAndIngredientChildRecipes")
//    @IterableMapping(qualifiedByName = "DepartmentMapperCustom.RecipeIgnoreBookAndIngredientChildRecipes")
//    Set<DepartmentEntity> toEntitySetIgnoreBookAndIngredientChildRecipes(Set<DepartmentDto> recipeDTOs);
//
//    @Named("DepartmentMapperCustom.RecipeSetIgnoreIngredientsAndBookChildRecipe333")
//    @IterableMapping(qualifiedByName = "DepartmentMapperCustom.RecipeIgnoreIngredientsAndBookChildRecipe")
//    Set<DepartmentEntity> toEntitySetIgnoreIngredientsAndBookChildRecipe(Set<DepartmentDto> recipeDTOs);
//
//    @Mappings({
//            @Mapping(target = "listProvinces", qualifiedByName = "ProvinceMapperCustom.IngredientSetIgnoreRecipes222"), // ingredients is a collection of complex objects, so we can't directly ignore its child properties as in the end, a Mapper needs to be defined to Map a single POJO into another
//    })
//    DepartmentEntity toEntity(DepartmentDto recipeDTO);
//
//    @Named("DepartmentMapperCustom.RecipeIgnoreBookAndIngredientChildRecipes")
//    @Mappings({
//            @Mapping(target = "listProvinces", qualifiedByName = "ProvinceMapperCustom.IngredientSetIgnoreRecipes222"),  // ingredients is a collection of complex objects, so we can't directly ignore its child properties as in the end, a Mapper needs to be defined to Map a single POJO into another
//    })
//    DepartmentEntity toEntityIgnoreBookAndIngredientChildRecipes(DepartmentDto recipeDTO);
//
//    @Named("DepartmentMapperCustom.RecipeIgnoreIngredientsAndBookChildRecipe")
//    @Mappings({
//            @Mapping(target = "listProvinces", ignore = true),
//    })
//    DepartmentEntity toEntityIgnoreIngredientsAndBookChildRecipe(DepartmentDto recipeDTO);
//
//}