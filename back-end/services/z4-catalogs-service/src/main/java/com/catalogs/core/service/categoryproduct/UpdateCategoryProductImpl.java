package com.catalogs.core.service.categoryproduct;

import com.catalogs.core.entity.CategoryProductEntity;
import com.catalogs.core.entity.mapper.CategoryProductMapper;
import com.catalogs.core.repository.CategoryProductRepository;
import com.shared.core.service.impl.GenericUpdateService;
import com.shared.dto.CategoryProductDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("updateCategoryProductImpl")
public class UpdateCategoryProductImpl extends GenericUpdateService<CategoryProductEntity, CategoryProductDto, Integer> {

    private final CategoryProductRepository categoryProductRepository;
    private final CategoryProductMapper categoryProductMapper;

    public UpdateCategoryProductImpl(CategoryProductRepository categoryProductRepository, CategoryProductMapper categoryProductMapper) {
        this.categoryProductRepository = categoryProductRepository;
        this.categoryProductMapper = categoryProductMapper;
    }

    @Override
    public JpaRepository<CategoryProductEntity, Integer> getJpaRepository() {
        return this.categoryProductRepository;
    }

    @Override
    public CategoryProductDto toDto(CategoryProductEntity countryEntity) {
        return this.categoryProductMapper.toDto(countryEntity);
    }

    @Override
    public void updateEntityFromDto(CategoryProductDto countryDto, CategoryProductEntity countryEntity) {
        this.categoryProductMapper.updateEntityFromDtoIgnoredId(countryDto, countryEntity);
    }

    @Override
    public CategoryProductEntity findEntityById(Integer idCountry) {
        return this.categoryProductRepository.findById(idCountry)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.CATEGORY.getValue(), idCountry));
    }

    @Override
    public void verifyUnique(Integer idCategoryProduct, CategoryProductDto categoryProductDto) {
        Boolean existsCode = this.categoryProductRepository.existsByCodeAndIdCategoryProductNot(categoryProductDto.getCode(), idCategoryProduct);
        Boolean existsName = this.categoryProductRepository.existsByNameAndIdCategoryProductNot(categoryProductDto.getName(), idCategoryProduct);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, categoryProductDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, categoryProductDto.getName());
    }

}