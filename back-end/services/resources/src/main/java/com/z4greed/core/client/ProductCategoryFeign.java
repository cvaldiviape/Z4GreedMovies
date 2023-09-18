package com.z4greed.core.client;

import com.shared.utils.response.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

@FeignClient(name = "service-catalog")
public interface ProductCategoryFeign {

    @GetMapping("api/category-products/{id}")
    ResponseDto findById(@PathVariable Integer id);

    @GetMapping("api/category-products/findAllByListIds")
    ResponseDto findAllByListIds(@RequestBody Collection<Integer> listIds);

}