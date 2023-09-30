package com.z4greed.core.client;

import com.shared.utils.response.ResponseDto;
//import com.z4greed.config.JwtTokenPropagatingInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

// @FeignClient(name = "service-catalog") -> le quito el "name" por que las solicitudes seran a travez de mi servidor "gateway", ahora seria "htto://localhost:8090/api/category-products"
@FeignClient(name = "service-catalog") // configuration = JwtTokenPropagatingInterceptor.class
public interface ProductCategoryFeign {

    @GetMapping("api/category-products/{id}")
    ResponseDto findById(@PathVariable Integer id);

    @PostMapping("api/category-products/findAllByListIds")
    ResponseDto findAllByListIds(@RequestBody Collection<Integer> listIds);

}