package com.z4greed.core.models.dto;

import com.z4greed.core.models.dto.base.BaseDto;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CategoryProductDto extends BaseDto {

    private Integer id_category_product;

}